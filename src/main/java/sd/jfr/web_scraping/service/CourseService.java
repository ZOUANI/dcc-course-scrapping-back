package sd.jfr.web_scraping.service;

import sd.jfr.web_scraping.bean.Chapter;

import java.io.IOException;
import java.util.List;

public interface CourseService {
    public int addCourse(String courseLink, List<Chapter> chapters) throws IOException;
}
