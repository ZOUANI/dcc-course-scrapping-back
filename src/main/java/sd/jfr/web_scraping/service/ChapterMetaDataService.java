package sd.jfr.web_scraping.service;

import sd.jfr.web_scraping.bean.ChapterMetaData;

public interface ChapterMetaDataService {
    public ChapterMetaData editChapterMetaData(ChapterMetaData chapterMetaData, Long id);

    public void deleteChapterMetaData(Long id);
}
