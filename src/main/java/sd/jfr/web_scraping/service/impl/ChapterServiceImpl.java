package sd.jfr.web_scraping.service.impl;

import com.detectlanguage.DetectLanguage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import sd.jfr.web_scraping.bean.Chapter;
import sd.jfr.web_scraping.service.ChapterService;
import sd.jfr.web_scraping.util.StringUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

@Service
public class ChapterServiceImpl implements ChapterService {

    @Override
    public List<Chapter> exportChapters(String url, String searchLocation) throws IOException {
        List<Chapter> chapters = new ArrayList<>();
        List<String> links = new ArrayList<>();
        Document doc = Jsoup.connect(url).get();
        Elements elements = doc.getElementsByClass(searchLocation);
        for (Element element : elements) {
            Elements chapters_links = element.select("a[href]");
            setChapterLinkAndAddToList(chapters_links, links, chapters);
        }
        return chapters;
    }

    public void setChapterLinkAndAddToList(Elements chapters_links, List<String> links, List<Chapter> chapters) throws IOException {
        for (Element chapter_link : chapters_links) {
            Chapter chapter = new Chapter();
            if (!links.contains(chapter_link.attr("href"))) {
                Vector<String> res = StringUtil.splitStrings(chapter_link.attr("href"), '/');
                chapter.setTitle(res.get(res.size() - 1));
                chapter.setChapterLink(chapter_link.absUrl("href"));
                //chapter.setChapterSection(extractChapterSectionHtml(chapter_link.absUrl("href")));
                //chapter.setChapterContent(getPageContent(chapter_link.absUrl("href")));
                chapters.add(chapter);
                links.add(chapter_link.absUrl("href"));
            }
        }
    }

    public String extractChapterSectionHtml(String chapterUrl) throws IOException {
        Document doc = Jsoup.connect(chapterUrl).get();
        String chapterSection = doc.getElementsByTag("body").html();
        return chapterSection;
    }

    @Override
    public String getPageContent(String url) throws IOException {
        String pageContent = "";
        Document doc = Jsoup.connect(url).get();
        for (Element element : doc.getAllElements()) {
            pageContent += element.ownText();
        }
        return pageContent;
    }
}
