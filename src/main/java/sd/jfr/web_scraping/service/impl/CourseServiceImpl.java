package sd.jfr.web_scraping.service.impl;

import com.detectlanguage.errors.APIError;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sd.jfr.web_scraping.bean.Course;
import sd.jfr.web_scraping.dao.CourseDao;
import sd.jfr.web_scraping.service.ChapterService;
import sd.jfr.web_scraping.service.CourseService;
import com.detectlanguage.DetectLanguage;

import java.io.IOException;
import org.jsoup.nodes.Element;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;
    @Autowired
    private ChapterService chapterService;

    @Override
    public Course addCourse(String courseLink, String searchLocation) throws IOException, APIError {
        Course courseCheck = courseDao.findByCourseLink(courseLink);
        DetectLanguage.apiKey = "7ce0b839d3933276497a7d500a3c1010";
        if (courseCheck == null) {
            Document doc = Jsoup.connect(courseLink).get();
            String language = DetectLanguage.simpleDetect(doc.getElementsByClass(searchLocation).text());
            String courseSummarySection = doc.getElementsByClass(searchLocation).html();
            Course course = new Course(doc.title(), language, courseLink, chapterService.exportChapters(courseLink, searchLocation), courseSummarySection);
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
    public String getPageContent(String url) throws IOException {
        Document doc = Jsoup.connect(url).get();
        return doc.getElementsByTag("body").html();
    }
}
