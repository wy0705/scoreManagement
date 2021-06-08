package com.easy.archiecture.controller;

import com.easy.archiecture.entity.Student;
import com.easy.archiecture.entity.Teacher;
import com.easy.archiecture.service.TeacherServiceImpl;
import com.easy.archiecture.support.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TeacherController {
    @Autowired
    private TeacherServiceImpl teacherService;

    @RequestMapping(value = "login",method = RequestMethod.POST)
    @ResponseBody
    public String login(String username,String password){
        Teacher teacher=new Teacher();
        if (teacher==null||teacher.getName()==null){
            return "用户不存在或用户名、密码错误";
        }
        String sign= JWTUtil.sign(teacher,60L * 1000L * 30L);
        return "hello"+teacher.getName()+"token:"+sign;
    }

    @RequestMapping(value = "logon",method = RequestMethod.POST)
    @ResponseBody
    public String logon(String username,String password){
        if (username==null||password==null){
            return "用户名和密码不能为空";
        }
        Teacher teacher=new Teacher(username,password);
        teacherService.insertTeacher(teacher);
        return teacher.getName()+"添加成功";
    }


    @RequestMapping(value = "registry", method = RequestMethod.POST)
    @ResponseBody
    public String registry(Teacher teacher) {
        boolean register = teacherService.register(teacher);
        if (register) {
            return "hello" + teacher.getName();
        }
        return "注册失败";
    }
}
