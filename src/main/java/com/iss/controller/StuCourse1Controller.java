package com.iss.controller;


import com.iss.entity.StuCourse1;
import com.iss.service.StuCourse1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@CrossOrigin//负责跨域用的，用于ajax请求的
@Controller//必须写spring用于做解析
public class StuCourse1Controller {

    @Autowired
    private StuCourse1Service stuCourse1Service;

    //1.查询全部学生选课(学生)
    @RequestMapping(value="getAllStudentCourse",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody//专门用于用户ajax请求以后的返回值
    public List<StuCourse1> getAllStudentCourse(){
        return  stuCourse1Service.getAllStudentCourse();
    }

    //2.通过学生学号查询选课！！！
    @RequestMapping(value="getCourseBystudentid",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody//专门用于用户ajax请求以后的返回值
    public List<StuCourse1>getCourseBystudentid(String studentid){
        return stuCourse1Service.getCourseBystudentid(studentid);
    }

    //3.通过学生学号和当前学期查询选课！！！
    @RequestMapping(value="getCourseBystudentid1",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody//专门用于用户ajax请求以后的返回值
    public List<StuCourse1>getCourseBystudentid(String studentid,String course_year,String term){
        if(0<Integer.parseInt(term)&&Integer.parseInt(term)<8){
            course_year=(Integer.parseInt(course_year)-1)+"-"+course_year;
            term="2";
        }else{
            course_year=(course_year+"-"+Integer.parseInt(course_year)+1);
            term="1";
        }
        System.out.println(course_year+term);
        return stuCourse1Service.getCourseBystudentid1(studentid,course_year,term);
    }
}
