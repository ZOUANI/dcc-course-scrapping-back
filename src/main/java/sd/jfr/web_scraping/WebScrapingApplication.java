package sd.jfr.web_scraping;

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
        int res = courseService.addCourse("https://openclassrooms.com/fr/courses/26832-apprenez-a-programmer-en-java", chapterService.exportChapters("https://openclassrooms.com/fr/courses/26832-apprenez-a-programmer-en-java", "course-part-summary__section"));
        System.out.println(res);
    }
}
