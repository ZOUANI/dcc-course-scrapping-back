package sd.jfr.web_scraping.service;

import sd.jfr.web_scraping.bean.Chapter;
import sd.jfr.web_scraping.dto.ChapterDto;
import sd.jfr.web_scraping.dto.CourseDto;

import java.io.IOException;
import java.util.List;

public interface ChapterService {

    public List<Chapter> exportChapters(String url, String searchLocation) throws IOException;

    public String getPageContent(String url) throws IOException;

    public ChapterDto getHmlPageContent(String url) throws IOException;
}
