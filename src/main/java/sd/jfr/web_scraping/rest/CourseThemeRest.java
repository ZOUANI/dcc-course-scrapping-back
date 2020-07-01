package sd.jfr.web_scraping.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sd.jfr.web_scraping.bean.CourseTheme;
import sd.jfr.web_scraping.service.CourseThemeService;

import java.util.List;

@Api("This part of service is in charge of the association courseTheme")
@RestController
@RequestMapping("/web-scraping/courseThemes/courseTheme")
public class CourseThemeRest {

    @Autowired
    private CourseThemeService courseThemeService;

    @ApiOperation("createCourse")
    @PostMapping("/createCourse/idCourse/{idCourse}/idTheme/{idTheme}")
    public CourseTheme createCourseTheme(@PathVariable Long idCourse, @PathVariable Long idTheme) {
        return courseThemeService.createCourseTheme(idCourse, idTheme);
    }

    @ApiOperation("Get Course Themes of a course")
    @GetMapping("/course_id/{course_id}")
    public List<CourseTheme> findByCourse_Id(@PathVariable Long course_id) {
        return courseThemeService.findByCourse_Id(course_id);
    }

    @ApiOperation("delete a courseTheme")
    @DeleteMapping("/id/{id}")
    public void deleteCourseTheme(@PathVariable Long id) {
        courseThemeService.deleteCourseTheme(id);
    }
}
