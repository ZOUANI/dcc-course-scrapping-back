package sd.jfr.web_scraping;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class WebScrapingApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebScrapingApplication.class, args);

        try {
            // Here we create a document object and use JSoup to fetch the website
            Document doc = Jsoup.connect("https://openclassrooms.com/fr/courses/26832-apprenez-a-programmer-en-java").get();

            // With the document fetched, we use JSoup's title() method to fetch the title
            System.out.printf("Title: %s\n", doc.title());

            //Course infos
            Elements courseInfos = doc.getElementsByClass("courseHeader__label");
            for (Element courseInfo : courseInfos) {
                System.out.println(courseInfo.text());
            }

            // Get the list of chapters
            Elements chapters = doc.getElementsByClass("course-part-summary");

            //Get certifications
            Elements certifications = doc.getElementsByClass("course-part-summary--certifying");

            //Fetch chapters
            for (Element chapter : chapters) {

                // Extract the chapter title
                String chapterTitle = chapter.getElementsByTag("h3").text();

                //check if the element is a chapter or certification
                if (!chapterTitle.isEmpty()) {
                    System.out.println(chapterTitle);
                } else {
                    //Fetch certifications
                    for (Element certificate : certifications) {
                        //Get certification title and link
                        String certificationTitle = certificate.getElementsByClass("course-part-summary__title").text();
                        String certificationLink = certificate.getElementsByTag("a").attr("href");
                        System.out.println(certificationTitle + "  " + "https://openclassrooms.com" + certificationLink);
                    }
                }
                //Get chapter Items
                Elements chaptersItems = chapter.getElementsByClass("course-part-summary__item");

                //Get chapter exercises
                Elements chaptersExercices = chapter.getElementsByClass("tocExercise__item");

                //Fetch chapter Items
                for (Element chapterItem : chaptersItems) {
                    String chapterItemTitle = chapterItem.getElementsByTag("a").text();
                    String chapterItemLink = chapterItem.getElementsByTag("a").attr("href");
                    System.out.println(chapterItemTitle + "  " + "https://openclassrooms.com" + chapterItemLink);
                }

                //Fetch exercice items
                for (Element exercice : chaptersExercices) {
                    String exerciceTitle = exercice.getElementsByClass("tocExercise__text").text();
                    String exerciceLink = exercice.getElementsByClass("tocExercise__link").attr("href");
                    System.out.println(exerciceTitle + "  " + "https://openclassrooms.com" + exerciceLink);
                }
                System.out.println("********************************************************************************");
            }
            // In case of any IO errors, we want the messages written to the console
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
