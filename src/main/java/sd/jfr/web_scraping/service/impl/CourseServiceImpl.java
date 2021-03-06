package sd.jfr.web_scraping.service.impl;

import com.detectlanguage.errors.APIError;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sd.jfr.web_scraping.bean.Course;
import sd.jfr.web_scraping.bean.CourseTheme;
import sd.jfr.web_scraping.dao.CourseDao;
import sd.jfr.web_scraping.dao.CourseThemeDao;
import sd.jfr.web_scraping.service.ChapterService;
import sd.jfr.web_scraping.service.CourseService;
import com.detectlanguage.DetectLanguage;

import java.io.IOException;
import java.util.List;

import org.jsoup.nodes.Element;
import sd.jfr.web_scraping.dto.CourseDto;
import sd.jfr.web_scraping.service.CourseThemeService;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;
    @Autowired
    private ChapterService chapterService;
    @Autowired
    private CourseThemeService courseThemeService;
    @Autowired
    private CourseThemeDao courseThemeDao;

    @Override
    public Course addCourse(String courseLink, String searchLocation) throws IOException, APIError {
        Course courseCheck = courseDao.findByCourseLink(courseLink);
        DetectLanguage.apiKey = "7ce0b839d3933276497a7d500a3c1010";
        if (courseCheck == null) {
            Document doc = Jsoup.connect(courseLink).get();
            String language = DetectLanguage.simpleDetect(doc.getElementsByClass(searchLocation).text());
            String courseSummarySection = doc.getElementsByClass(searchLocation).html();
            Course course = new Course(doc.title(), language, courseLink, chapterService.exportChapters(courseLink, searchLocation), courseSummarySection);
            course.setCourseSummarySectionContent(chapterService.getPageContent(courseLink));
            return course;
        } else {
            return null;
        }
    }

    @Override
    public Course findByCourseLink(String courseLink) {
        if (courseDao.findByCourseLink(courseLink) != null) {
            return courseDao.findByCourseLink(courseLink);
        } else {
            return null;
        }
    }

    @Override
    public CourseDto getPageContent(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        CourseDto courseDto = new CourseDto();
        courseDto.setHtmlPageContent(doc.html());
        return courseDto;
    }

    @Override
    public List<Course> getAllCourses() {
        return courseDao.findAll();
    }

    @Override
    public Course updateCourse(Long id, Course course) {
        Course course1 = courseDao.getOne(id);
        course1.setDescription(course.getDescription());
        course1.setDifficulty(course.getDifficulty());
        course1.setHourlyVolume(course.getHourlyVolume());
        course1.setRating(course.getRating());
        return courseDao.save(course1);
    }

    @Override
    public void deleteCourse(Long id) {
        List<CourseTheme> courseThemes = courseThemeService.findByCourse_Id(id);
        for (CourseTheme courseTheme : courseThemes) {
            courseThemeDao.delete(courseTheme);
        }
        Course course = courseDao.getOne(id);
        courseDao.delete(course);

    }
}
