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
import java.util.Vector;


@SpringBootApplication
public class WebScrapingApplication {
    static Vector<String> splitStrings(String str, char dl) {
        String word = "";

        // to count the number of split Strings
        int num = 0;

        // adding delimiter character
        // at the end of 'str'
        str = str + dl;

        // length of 'str'
        int l = str.length();

        // traversing 'str' from left to right
        Vector<String> substr_list = new Vector<String>();
        for (int i = 0; i < l; i++) {

            // if str[i] is not equal to the delimiter
            // character then accumulate it to 'word'
            if (str.charAt(i) != dl) {
                word = word + str.charAt(i);
            } else {

                // if 'word' is not an empty String,
                // then add this 'word' to the array
                // 'substr_list[]'
                if ((int) word.length() != 0) {
                    substr_list.add(word);
                }

                // reset 'word'
                word = "";
            }
        }

        // return the splitted Strings
        return substr_list;
    }

    private static List<String> findLinks(String url, String searchLocation) throws IOException {
        List<String> links = new ArrayList<>();
        Document doc = Jsoup.connect(url).get();

        Element taglang = doc.select("html").first();
        System.out.println("course lang " + taglang.attr("lang"));
        System.out.println("course title " + doc.title());
        Elements elements = doc.getElementsByClass(searchLocation);
        for (Element element : elements) {
            Elements chapters_links = element.select("a[href]");
            for (Element chapter_link : chapters_links) {
                if (!links.contains(chapter_link.attr("href"))) {
                    Vector<String> res = splitStrings(chapter_link.attr("href"), '/');
                    System.out.println(res.get(res.size() - 1));
                    if (chapter_link.attr("href").contains("https://")) {
                        links.add(chapter_link.attr("href"));
                    } else {
                        links.add(chapter_link.absUrl("href"));
                    }
                }
            }
        }
        return links;
    }

    public static void main(String[] args) throws IOException {
        SpringApplication.run(WebScrapingApplication.class, args);
        for (String link : findLinks("https://openclassrooms.com/fr/courses/26832-apprenez-a-programmer-en-java", "course-part-summary__section")) {
            System.out.println(link);
        }
    }

}
