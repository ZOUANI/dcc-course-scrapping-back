package sd.jfr.web_scraping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@SpringBootApplication
public class WebScrapingApplication {

    private static List<String> findLinks(String url, String searchLocation) throws IOException {

        List<String> links = new ArrayList<>();

        Document doc = Jsoup.connect(url).get();
        //System.out.println(doc);
        Elements elements = doc.getElementsByClass(searchLocation);
        //System.out.println(elements);
        for (Element element : elements) {
            Elements chapters_links = element.select("a[href]");
            for (Element chapter_link : chapters_links) {
                if (!links.contains(chapter_link.attr("href"))) {
                    links.add(chapter_link.attr("href"));
                }

            }
        }

        return links;

    }

    public static void main(String[] args) throws IOException {
        SpringApplication.run(WebScrapingApplication.class, args);
        for (String link : findLinks("https://openclassrooms.com/fr/courses/235344-apprenez-a-programmer-en-python", "course-part-summary__section")) {
            System.out.println(link);
        }
    }

}
