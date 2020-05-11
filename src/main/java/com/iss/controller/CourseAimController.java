package com.iss.controller;


import com.iss.entity.CourseAim;
import com.iss.service.CourseAimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@CrossOrigin//负责跨域用的，用于ajax请求的
@Controller//必须写spring用于做解析
public class CourseAimController {

    @Autowired
    private CourseAimService courseAimService;

    //1.通过学年、课程号查询课程目标
    @RequestMapping(value = "getAimByCourseTime",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody//专门用于用户ajax请求以后的返回值
    public List<CourseAim> getAimByCourseTime(String course_year,String courseid){
        //TeacherTask teacherTask1=new TeacherTask();
        return courseAimService.getAimByCourseTime(course_year,courseid);
    }

    //2.添加课程目标


    //3.删除一条课程目标
    @RequestMapping(value="deleteCourseAim",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody//专门用于用户ajax请求以后的返回值
    public int deleteCourseAim(String course_year,String courseid,String aimid) {
        return courseAimService.deleteCourseAim(course_year,courseid,aimid);
    }

    //4.修改一条课程目标
    @RequestMapping(value="updateCourseAim",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody//专门用于用户ajax请求以后的返回值
    public int updateCourseAim(String aim,String course_year,String courseid,String aimid) {
        return courseAimService.updateCourseAim(aim, course_year, courseid, aimid);
    }
}
