package sd.jfr.web_scraping.service;

import sd.jfr.web_scraping.bean.Chapter;

import java.io.IOException;
import java.util.List;

public interface ChapterService {
    public List<Chapter> exportChapters(String url, String searchLocation) throws IOException;
}
