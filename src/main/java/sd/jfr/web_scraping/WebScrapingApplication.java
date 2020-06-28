package sd.jfr.web_scraping;

import org.jsoup.Jsoup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sd.jfr.web_scraping.service.ChapterService;
import sd.jfr.web_scraping.service.CourseService;

@SpringBootApplication
public class WebScrapingApplication implements CommandLineRunner {

    @Autowired
    private CourseService courseService;
    @Autowired
    private ChapterService chapterService;

    public static void main(String[] args) {
        SpringApplication.run(WebScrapingApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //System.out.println(chapterService.getPageContent("https://openclassrooms.com/en/courses/235344-apprenez-a-programmer-en-python"));
        // Course res = courseService.addCourse("https://www.khanacademy.org/computing/computer-programming", "_14kisdro");
        // System.out.println(res);
        // System.out.println(chapterService.exportChapters("https://fr.khanacademy.org/computing/computer-programming", "_14kisdro").size());
    }
}
