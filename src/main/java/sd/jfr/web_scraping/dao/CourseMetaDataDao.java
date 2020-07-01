package sd.jfr.web_scraping.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sd.jfr.web_scraping.bean.CourseMetaData;

@Repository
public interface CourseMetaDataDao extends JpaRepository<CourseMetaData, Long> {
    public CourseMetaData findByTitle(String title);
}
