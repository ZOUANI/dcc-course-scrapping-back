package sd.jfr.web_scraping.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sd.jfr.web_scraping.bean.CourseMetaData;
import sd.jfr.web_scraping.service.CourseMetaDataService;

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
}
