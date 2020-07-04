package sd.jfr.web_scraping.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sd.jfr.web_scraping.bean.ChapterMetaData;
import sd.jfr.web_scraping.service.ChapterMetaDataService;

@Api("This part of service is in charge of chaptersMetaData")
@RestController
@RequestMapping("/web-scraping/chaptersMetaData/chapterMetaData")
public class ChapterMetaDataRest {
    @Autowired
    private ChapterMetaDataService chapterMetaDataService;

    @ApiOperation("edit chapterMetaData")
    @PutMapping("/id/{id}")
    public ChapterMetaData editChapterMetaData(@RequestBody ChapterMetaData chapterMetaData, @PathVariable Long id) {
        return chapterMetaDataService.editChapterMetaData(chapterMetaData, id);
    }

    @ApiOperation("delete chapterMetaData")
    @DeleteMapping("/id/{id}")
    public void deleteChapterMetaData(@PathVariable Long id) {
        chapterMetaDataService.deleteChapterMetaData(id);
    }
}
