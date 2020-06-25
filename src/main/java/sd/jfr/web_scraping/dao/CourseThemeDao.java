package sd.jfr.web_scraping.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sd.jfr.web_scraping.bean.CourseTheme;

@Repository
public interface CourseThemeDao extends JpaRepository<CourseTheme, Long> {
}
