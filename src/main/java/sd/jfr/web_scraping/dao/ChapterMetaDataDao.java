package sd.jfr.web_scraping.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sd.jfr.web_scraping.bean.ChapterMetaData;

@Repository
public interface ChapterMetaDataDao extends JpaRepository<ChapterMetaData, Long> {
}
