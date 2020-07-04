package sd.jfr.web_scraping.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sd.jfr.web_scraping.bean.CourseMetaData;
import sd.jfr.web_scraping.service.CourseMetaDataService;

import java.util.List;

@Api("This part of service is in charge of web scraping in order to save coursesMetaData with chaptersMetaData")
@RestController
@RequestMapping("/web-scraping/coursesMetaData/courseMetaData")
public class CourseMetaDataRest {
    @Autowired
    private CourseMetaDataService courseMetaDataService;

    @ApiOperation("post courseMetaData with chaptersMetaData")
    @PostMapping("/")
    public CourseMetaData createCourseMetaData(@RequestBody CourseMetaData courseMetaData) {
        return courseMetaDataService.createCourseMetaData(courseMetaData);
    }

    @ApiOperation("get all courseMetaData with chapters MetaData")
    @GetMapping("/")
    public List<CourseMetaData> findAll() {
        return courseMetaDataService.findAll();
    }

    @ApiOperation("edit courseMetaData")
    @PutMapping("/id/{id}")
    public CourseMetaData editCourseMetaData(@RequestBody CourseMetaData courseMetaData, @PathVariable Long id) {
        return courseMetaDataService.editCourseMetaData(courseMetaData, id);
    }

    @ApiOperation("delete courseMetaData")
    @DeleteMapping("/id/{id}")
    public void deleteCourseMetaData(@PathVariable Long id) {
        courseMetaDataService.deleteCourseMetaData(id);
    }
}
