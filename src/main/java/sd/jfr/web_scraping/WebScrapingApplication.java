package sd.jfr.web_scraping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import sd.jfr.web_scraping.service.CourseService;


@SpringBootApplication
public class WebScrapingApplication {

    @Autowired
    private CourseService courseService;

    public static void main(String[] args) {
        SpringApplication.run(WebScrapingApplication.class, args);
    }

/*
    @Override
    public void run(String... args) throws Exception {
        // Course res = courseService.addCourse("https://www.khanacademy.org/computing/computer-programming", "_14kisdro");
        ;
        // System.out.println(res);
        // System.out.println(chapterService.exportChapters("https://fr.khanacademy.org/computing/computer-programming", "_14kisdro").size());
    }*/
}
