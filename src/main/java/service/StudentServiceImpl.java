package service;

import dao.StudentDao;
import entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl {
    @Autowired
    private StudentDao studentDao;

    public Student findByStuId(int id){
        return studentDao.findByStuId(id);
    }

    public Student findByName(String name){
        return studentDao.findByName(name);
    }

    public int insertStudent(Student student){
        return studentDao.insertStudent(student);
    }

    public int updateStudent(Student student){
        return studentDao.updateStudent(student);
    }
}
