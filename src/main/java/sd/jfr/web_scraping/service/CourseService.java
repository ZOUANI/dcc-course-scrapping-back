package sd.jfr.web_scraping.service;

import com.detectlanguage.errors.APIError;
import sd.jfr.web_scraping.bean.Course;

import java.io.IOException;

public interface CourseService {

    public Course addCourse(String courseLink, String searchLocation) throws IOException, APIError;

    public Course findByCourseLink(String courseLink);

    public String getPageContent(String url) throws IOException;

}
