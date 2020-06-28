package sd.jfr.web_scraping.rest;

import com.detectlanguage.errors.APIError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import sd.jfr.web_scraping.bean.Course;
import sd.jfr.web_scraping.service.CourseService;

import java.io.IOException;

import sd.jfr.web_scraping.dao.CourseDao;
import sd.jfr.web_scraping.dto.CourseDto;

@RestController
@RequestMapping("/web-scraping/courses/course")
public class CourseRest {

    @Autowired
    private CourseService courseService;
    @Autowired
    private CourseDao courseDao;

    @PostMapping("/searchLocation/{searchLocation}")
    public Course addCourse(@PathVariable String searchLocation, @RequestBody CourseDto courseDto) throws IOException, APIError {
        return courseService.addCourse(courseDto.getCourseLink(), searchLocation);
    }

    @PostMapping("/")
    public Course saveCourse(@RequestBody Course course) {
        courseDao.save(course);
        return course;
    }

    @PostMapping("/findByCourseLink")
    public Course findByCourseLink(@RequestBody CourseDto courseDto) {
        return courseService.findByCourseLink(courseDto.getCourseLink());
    }

    @PostMapping(value = "/getPageContent",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public CourseDto getPageContent(@RequestBody CourseDto courseDto) throws IOException {
        return courseService.getPageContent(courseDto.getCourseLink());
    }

}
