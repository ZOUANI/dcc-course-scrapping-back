package sd.jfr.web_scraping.service;

import sd.jfr.web_scraping.bean.CourseTheme;

import java.util.List;

public interface CourseThemeService {
    public CourseTheme createCourseTheme(Long idCourse, Long idTheme);

    public List<CourseTheme> findByCourse_Id(Long course_id);

    public void deleteCourseTheme(Long id);


}
