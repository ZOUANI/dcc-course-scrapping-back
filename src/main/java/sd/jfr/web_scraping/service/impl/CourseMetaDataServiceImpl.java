package sd.jfr.web_scraping.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sd.jfr.web_scraping.bean.Course;
import sd.jfr.web_scraping.bean.CourseMetaData;
import sd.jfr.web_scraping.dao.CourseMetaDataDao;
import sd.jfr.web_scraping.service.CourseMetaDataService;

import java.util.List;

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

    @Override
    public List<CourseMetaData> findAll() {
        return courseMetaDataDao.findAll();
    }

    @Override
    public CourseMetaData editCourseMetaData(CourseMetaData courseMetaData, Long id) {
        CourseMetaData course1 = courseMetaDataDao.getOne(id);
        course1.setDescription(courseMetaData.getDescription());
        course1.setTitle(courseMetaData.getTitle());
        course1.setBagOfWords(courseMetaData.getBagOfWords());
        return courseMetaDataDao.save(course1);
    }

    @Override
    public void deleteCourseMetaData(Long id) {
        CourseMetaData courseMetaData = courseMetaDataDao.getOne(id);
        courseMetaDataDao.delete(courseMetaData);
    }
}
