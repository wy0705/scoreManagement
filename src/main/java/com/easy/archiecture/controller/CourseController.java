package com.easy.archiecture.controller;

import com.easy.archiecture.entity.Course;
import com.easy.archiecture.entity.Student;
import com.easy.archiecture.service.CourseServiceImpl;
import com.easy.archiecture.service.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CourseController {
    @Autowired
    private CourseServiceImpl courseService;
    @Autowired
    private StudentServiceImpl studentService;

    @RequestMapping(value = "addcou",method = RequestMethod.POST)
    @ResponseBody
    public String addcou(String name,int tid,String sid,int score){
        Course course=new Course(name,tid,sid,score);
        if (course==null||course.getName()==null||course.getName()==null){
            return "信息不能为空!";
        }
        courseService.insertCourse(course);
        return "信息添加成功";
    }

    @RequestMapping(value = "findbyns",method = RequestMethod.POST)
    @ResponseBody
    public String findbynameandsid(String name,String sid){
        Course course=courseService.findByNameAndSid(name,sid);
        Student student=studentService.findByStuSid(sid);
        if (course==null){
            if (student==null)
                return "该学号不存在";
            return "该信息不存在";
        }
        System.out.println(student.getName()+"的"+course.getName()+"成绩为："+course.getScore());
        return student.getName()+"的"+course.getName()+"成绩为："+course.getScore();
    }
}
