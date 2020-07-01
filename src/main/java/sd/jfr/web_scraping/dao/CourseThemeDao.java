package sd.jfr.web_scraping.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sd.jfr.web_scraping.bean.CourseTheme;

import java.util.List;

@Repository
public interface CourseThemeDao extends JpaRepository<CourseTheme, Long> {
    public List<CourseTheme> findByCourse_Id(Long course_id);

    public CourseTheme findByCourse_IdAndTheme_Id(Long course_id, Long theme_id);

}
