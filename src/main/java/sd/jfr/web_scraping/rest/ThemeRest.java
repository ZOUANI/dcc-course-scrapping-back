package sd.jfr.web_scraping.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sd.jfr.web_scraping.bean.Theme;
import sd.jfr.web_scraping.service.ThemeService;

import java.util.List;

@Api("This part of service is in charge of the course themes")
@RestController
@RequestMapping("/web-scraping/themes/theme")
public class ThemeRest {

    @Autowired
    private ThemeService themeService;

    @ApiOperation("get themes that doesn't below to a course")
    @GetMapping("/themesToAdd/course_id/{course_id}")
    public List<Theme> findThemesToAdd(@PathVariable Long course_id) {
        return themeService.findThemesToAdd(course_id);
    }
}
