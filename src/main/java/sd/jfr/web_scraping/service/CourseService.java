package sd.jfr.web_scraping.service;

import com.detectlanguage.errors.APIError;
import sd.jfr.web_scraping.bean.Course;

import java.io.IOException;
import java.util.List;

import sd.jfr.web_scraping.dto.CourseDto;

public interface CourseService {

    public Course addCourse(String courseLink, String searchLocation) throws IOException, APIError;

    public Course findByCourseLink(String courseLink);

    public CourseDto getPageContent(String url) throws IOException;

    public List<Course> getAllCourses();

    public Course updateCourse(Long id, Course course);

    public void deleteCourse(Long id);

}
