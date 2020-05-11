package com.iss.controller;

import com.iss.entity.Course;
import com.iss.service.CourseService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@CrossOrigin//负责跨域用的，用于ajax请求的
@Controller//必须写spring用于做解析
public class CourseController {

    @Autowired
    private CourseService courseService;

    //1.查询课程表中所有的课程信息
    @RequestMapping(value="getAllCourse",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody//专门用于用户ajax请求以后的返回值
    public List<Course> getAllCourse(){
        return  courseService.getAllCourse();
    }

    //2.前端通过课程ID进行课程信息的查询
    @RequestMapping(value="getAllCourse1",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody//专门用于用户ajax请求以后的返回值
    public HashMap getAllCourse1(int pageIndex,int pageSize,String courseid){
        List<Course> list=courseService.getAllCourse1(pageIndex,pageSize,courseid);
        int total;
        if (courseid.equals("%")){ total=courseService.getAllCourseNumber();
        }else { total=courseService.getCourseNumberByCourseid(courseid); }
        HashMap map=new HashMap();
        map.put("total",total);
        map.put("row",list);
        return map;
    }

    //3.向课程数据表中添加课程信息
    @RequestMapping(value = "addCourse",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody//专门用于用户ajax请求以后的返回值
    public int addCourse(Course course){
        return courseService.addCourse(course);//=0表示添加失败，=1表示添加成功
    }

    //4.删除课程表中的某一条数据
    @RequestMapping(value="deleteCourse",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody//专门用于用户ajax请求以后的返回值
    public int deleteCourse(String courseid) {
        return courseService.deleteCourse(courseid);
    }

    //5.修改课程表中的课程信息
    @RequestMapping(value="updateCourse",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody//专门用于用户ajax请求以后的返回值
    public int updateCourse(String cname,String classification,String credit,String course_hours,String course_college,String courseid) {
        return courseService.updateCourse(cname,classification,credit,course_hours,course_college,courseid);
    }
}
