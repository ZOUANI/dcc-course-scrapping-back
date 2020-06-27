package sd.jfr.web_scraping.service.impl;

import com.detectlanguage.errors.APIError;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sd.jfr.web_scraping.bean.Chapter;
import sd.jfr.web_scraping.bean.Course;
import sd.jfr.web_scraping.dao.CourseDao;
import sd.jfr.web_scraping.service.ChapterService;
import sd.jfr.web_scraping.service.CourseService;
import com.detectlanguage.DetectLanguage;


import java.io.IOException;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;
    @Autowired
    private ChapterService chapterService;

    @Override
    public int addCourse(String courseLink, String searchLocation) throws IOException, APIError {
        Course courseCheck = courseDao.findByCourseLink(courseLink);
        DetectLanguage.apiKey = "7ce0b839d3933276497a7d500a3c1010";
        if (courseCheck == null) {
            Document doc = Jsoup.connect(courseLink).get();
            String language = DetectLanguage.simpleDetect(doc.getElementsByClass(searchLocation).text());
            //Element taglang = doc.select("html").first();
            String courseSummarySection = doc.getElementsByClass(searchLocation).html();
            Course course = new Course(doc.title(), language, courseLink, chapterService.exportChapters(courseLink, searchLocation), courseSummarySection);
            courseDao.save(course);
            return 1;
        } else return -1;
    }
}
