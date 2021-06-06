package com.easy.archiecture.service;

import com.easy.archiecture.dao.StudentDao;
import com.easy.archiecture.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl {
    @Autowired
    private StudentDao studentDao;

    public Student findByStuId(int id){
        return studentDao.findByStuId(id);
    }

    public Student findByStuSid(String sid){
        return studentDao.findByStuSid(sid);
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
