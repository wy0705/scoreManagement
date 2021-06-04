package service;

import dao.CourseDao;
import entity.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl {
    @Autowired
    private CourseDao courseDao;

    public Course findByCouId(int id){
        return courseDao.findByCouId(id);
    }

    public Course findByCouName(String name){
        return courseDao.findByCouName(name);
    }

    public List<Integer> findByCouTea(int tid){
        return courseDao.findByCouTea(tid);
    }

    public int insertCourse(Course course){
        return courseDao.insertCourse(course);
    }
}
