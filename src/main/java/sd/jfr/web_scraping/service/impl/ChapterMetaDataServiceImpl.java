package sd.jfr.web_scraping.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sd.jfr.web_scraping.bean.ChapterMetaData;
import sd.jfr.web_scraping.dao.ChapterMetaDataDao;
import sd.jfr.web_scraping.service.ChapterMetaDataService;

@Service
public class ChapterMetaDataServiceImpl implements ChapterMetaDataService {
    @Autowired
    private ChapterMetaDataDao chapterMetaDataDao;

    @Override
    public ChapterMetaData editChapterMetaData(ChapterMetaData chapterMetaData, Long id) {
        ChapterMetaData chapterMetaData1 = chapterMetaDataDao.getOne(id);
        chapterMetaData1.setTitle(chapterMetaData.getTitle());
        chapterMetaData1.setBagOfWords(chapterMetaData.getBagOfWords());
        return chapterMetaDataDao.save(chapterMetaData1);
    }

    @Override
    public void deleteChapterMetaData(Long id) {
        ChapterMetaData chapterMetaData = chapterMetaDataDao.getOne(id);
        chapterMetaDataDao.delete(chapterMetaData);
    }
}
