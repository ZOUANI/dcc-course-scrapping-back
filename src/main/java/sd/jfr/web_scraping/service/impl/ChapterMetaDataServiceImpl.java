package sd.jfr.web_scraping.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sd.jfr.web_scraping.dao.ChapterMetaDataDao;
import sd.jfr.web_scraping.service.ChapterMetaDataService;

@Service
public class ChapterMetaDataServiceImpl implements ChapterMetaDataService {
    @Autowired
    private ChapterMetaDataDao chapterMetaDataDao;
}
