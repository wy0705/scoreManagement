package com.easy.archiecture.controller;

import com.easy.archiecture.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.easy.archiecture.service.StudentServiceImpl;
import support.JWTUtil;

@Controller
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;

    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public String login(String sid,String password){
        Student student=new Student();
        if (student==null||student.getName()==null){
            return "用户不存在或用户名、密码错误";
        }
        String sign= JWTUtil.sign(student,60L * 1000L * 30L);
        return "hello"+student.getName()+"token:"+sign;
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
