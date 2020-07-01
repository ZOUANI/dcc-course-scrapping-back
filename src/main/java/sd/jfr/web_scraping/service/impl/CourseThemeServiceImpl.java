package sd.jfr.web_scraping.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sd.jfr.web_scraping.bean.Course;
import sd.jfr.web_scraping.bean.CourseTheme;
import sd.jfr.web_scraping.bean.Theme;
import sd.jfr.web_scraping.dao.CourseDao;
import sd.jfr.web_scraping.dao.CourseThemeDao;
import sd.jfr.web_scraping.dao.ThemeDao;
import sd.jfr.web_scraping.service.CourseThemeService;

import java.util.List;

@Service
public class CourseThemeServiceImpl implements CourseThemeService {
    @Autowired
    private CourseThemeDao courseThemeDao;

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private ThemeDao themeDao;

    @Override
    public CourseTheme createCourseTheme(Long idCourse, Long idTheme) {
        CourseTheme courseThemeCheck = courseThemeDao.findByCourse_IdAndTheme_Id(idCourse, idTheme);
        if (courseThemeCheck != null) {
            return null;
        } else {
            Course course = courseDao.getOne(idCourse);
            Theme theme = themeDao.getOne(idTheme);
            CourseTheme courseTheme = new CourseTheme();
            courseTheme.setCourse(course);
            courseTheme.setTheme(theme);
            return courseThemeDao.save(courseTheme);
        }
    }

    @Override
    public List<CourseTheme> findByCourse_Id(Long course_id) {
        return courseThemeDao.findByCourse_Id(course_id);
    }

    @Override
    public void deleteCourseTheme(Long id) {
        CourseTheme courseTheme = courseThemeDao.getOne(id);
        courseThemeDao.delete(courseTheme);
    }
}
