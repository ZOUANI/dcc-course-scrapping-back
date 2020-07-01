package sd.jfr.web_scraping.service;


import sd.jfr.web_scraping.bean.Theme;

import java.util.List;

public interface ThemeService {
    public List<Theme> findThemesToAdd(Long course_id);

    public List<Theme> getThemesByCourse(Long course_id);
}
