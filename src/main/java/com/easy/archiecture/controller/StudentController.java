package com.easy.archiecture.controller;

import com.easy.archiecture.entity.Student;
import com.easy.archiecture.support.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.easy.archiecture.service.StudentServiceImpl;

@Controller
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;

    @RequestMapping(value = "addstudnet",method = RequestMethod.POST)
    @ResponseBody
    public String addstudent(String sid,String name,int age,String major,String password){
        Student student=new Student(sid,name,age,major,password);
        if (student==null||student.getName()==null||student.getSid()==null||student.getPassword()==null){
            return "用户名、密码和学号不能为空";
        }
        studentService.insertStudent(student);
        return student.getName()+"信息创建成功！";
    }

    @RequestMapping(value = "find_name",method = RequestMethod.GET)
    @ResponseBody
    public String registry(@RequestParam String sid){
        Student student=studentService.findByStuSid(sid);
        if (student!=null){
            return student.getName();
        }
        return "未找到该用户";
    }
}
