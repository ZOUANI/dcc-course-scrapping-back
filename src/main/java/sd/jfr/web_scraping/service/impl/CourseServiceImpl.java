package sd.jfr.web_scraping.service.impl;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sd.jfr.web_scraping.bean.Chapter;
import sd.jfr.web_scraping.bean.Course;
import sd.jfr.web_scraping.dao.CourseDao;
import sd.jfr.web_scraping.service.CourseService;

import java.io.IOException;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;

    @Override
    public int addCourse(String courseLink, List<Chapter> chapters) throws IOException {
        Course courseCheck = courseDao.findByCourseLink(courseLink);
        if (courseCheck == null) {
            Document doc = Jsoup.connect(courseLink).get();
            Element taglang = doc.select("html").first();
            Course course = new Course(doc.title(), taglang.attr("lang"), courseLink, chapters);
            courseDao.save(course);
            return 1;
        } else return -1;
    }
}
