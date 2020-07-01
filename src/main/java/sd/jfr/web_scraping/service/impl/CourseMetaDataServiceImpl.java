package sd.jfr.web_scraping.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sd.jfr.web_scraping.bean.CourseMetaData;
import sd.jfr.web_scraping.dao.CourseMetaDataDao;
import sd.jfr.web_scraping.service.CourseMetaDataService;

@Service
public class CourseMetaDataServiceImpl implements CourseMetaDataService {

    @Autowired
    private CourseMetaDataDao courseMetaDataDao;

    @Override
    public CourseMetaData createCourseMetaData(CourseMetaData courseMetaData) {
        CourseMetaData courseMetaData1 = courseMetaDataDao.findByTitle(courseMetaData.getTitle());
        if (courseMetaData1 != null) return null;
        else {
            return courseMetaDataDao.save(courseMetaData);
        }
    }
}
