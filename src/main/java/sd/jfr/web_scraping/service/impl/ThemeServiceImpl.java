package sd.jfr.web_scraping.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sd.jfr.web_scraping.bean.CourseTheme;
import sd.jfr.web_scraping.bean.Theme;
import sd.jfr.web_scraping.dao.CourseDao;
import sd.jfr.web_scraping.dao.CourseThemeDao;
import sd.jfr.web_scraping.dao.ThemeDao;
import sd.jfr.web_scraping.service.ThemeService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ThemeServiceImpl implements ThemeService {

    @Autowired
    private CourseThemeDao courseThemeDao;

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private ThemeDao themeDao;

    @Override
    public List<Theme> findThemesToAdd(Long course_id) {
        List<Theme> themesByCourse = getThemesByCourse(course_id);
        List<Theme> themesToAdd = new ArrayList<>();
        for (Theme theme : themeDao.findAll()) {
            if (!themesByCourse.contains(theme)) {
                themesToAdd.add(theme);
            }
        }
        return themesToAdd;
    }

    @Override
    public List<Theme> getThemesByCourse(Long course_id) {
        List<Theme> themes = new ArrayList<>();
        List<CourseTheme> courseThemesByCourseId = courseThemeDao.findByCourse_Id(course_id);
        for (CourseTheme courseTheme : courseThemesByCourseId) {
            themes.add(themeDao.getOne(courseTheme.getTheme().getId()));
        }
        return themes;
    }
}
