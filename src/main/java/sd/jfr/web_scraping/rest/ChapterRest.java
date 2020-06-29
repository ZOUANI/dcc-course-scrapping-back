package sd.jfr.web_scraping.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sd.jfr.web_scraping.dto.ChapterDto;
import sd.jfr.web_scraping.service.ChapterService;

import java.io.IOException;

@Api("This part of service is in charge of managing chapter entity")
@RestController
@RequestMapping("/web-scraping/chapters/chapter")
public class ChapterRest {
    @Autowired
    ChapterService chapterService;

    @ApiOperation("get the html of a chapter page")
    @PostMapping(value = "/getChapterHtmlPageContent")
    public ChapterDto getHmlPageContent(@RequestBody ChapterDto chapterDto) throws IOException {
        return chapterService.getHmlPageContent(chapterDto.getChapterLink());
    }
}
