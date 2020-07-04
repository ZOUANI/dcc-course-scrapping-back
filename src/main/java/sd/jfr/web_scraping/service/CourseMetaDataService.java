package sd.jfr.web_scraping.service;

import sd.jfr.web_scraping.bean.CourseMetaData;

import java.util.List;

public interface CourseMetaDataService {
    public CourseMetaData createCourseMetaData(CourseMetaData courseMetaData);

    public List<CourseMetaData> findAll();

    public CourseMetaData editCourseMetaData(CourseMetaData courseMetaData, Long id);

    public void deleteCourseMetaData(Long id);
}
