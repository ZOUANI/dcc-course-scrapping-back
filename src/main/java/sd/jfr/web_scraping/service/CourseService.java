package sd.jfr.web_scraping.service;

import com.detectlanguage.errors.APIError;

import java.io.IOException;

public interface CourseService {
    public int addCourse(String courseLink, String searchLocation) throws IOException, APIError;
}
