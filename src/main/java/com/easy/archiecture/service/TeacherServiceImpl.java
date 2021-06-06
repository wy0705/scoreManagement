package com.easy.archiecture.service;

import com.easy.archiecture.dao.TeacherDao;
import com.easy.archiecture.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionTemplate;
import org.springframework.util.DigestUtils;

@Service
public class TeacherServiceImpl {
    @Autowired
    private TeacherDao teacherDao;

    @Autowired
    private TransactionTemplate txTemplate;

    public Teacher findByTeaId(int id){
        return teacherDao.findByTeaId(id);
    }

    public Teacher findByTeaName(String name){
        return teacherDao.findByTeaName(name);
    }

    public int insertTeacher(Teacher teacher){
        return teacherDao.insertTeacher(teacher);
    }

    public boolean register(Teacher teacher){
        //用户重名校验
        Teacher teacherByName=findByTeaName(teacher.getName());
        if (teacherByName!=null&&teacherByName.getName()!=null&&teacher.getName().equals(teacher.getName())){
            return true;
        }
        //对用户密码进行MD5,目的是，数据库中的敏感数据，不要存储明文。
        teacher.setPassword(DigestUtils.md5DigestAsHex(teacher.getPassword().getBytes()));
        return teacherDao.insertTeacher(teacher) != 0;
    }

}
