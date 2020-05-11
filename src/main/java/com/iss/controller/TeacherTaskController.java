package com.iss.controller;

import com.iss.entity.TeacherTask;
import com.iss.service.TeacherTaskService;
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
public class TeacherTaskController {

    @Autowired
    private TeacherTaskService teacherTaskService;

    //1.查询全部教学任务
    @RequestMapping(value="getAllTeaTask",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody//专门用于用户ajax请求以后的返回值
    public List<TeacherTask> getAllTeaTask(){
        return  teacherTaskService.getAllTeaTask();
    }

    //2.前端通过学年、学期、课程号、课程名称查询教学任务
    @RequestMapping(value="getAllTeaTask1",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody//专门用于用户ajax请求以后的返回值
    public HashMap getAllTeaTask1(int pageIndex,int pageSize,String course_year,String term,String courseid,String cname){
        List<TeacherTask> list=teacherTaskService.getAllTeaTask1(pageIndex,pageSize,course_year,term,courseid,cname);
        int total;
        if (course_year.equals("%")||term.equals("%")||courseid.equals("%")||cname.equals("%")){ total=teacherTaskService.getAllCourseNumber();
        }else { total=teacherTaskService.getAllTeaTaskNumber1(course_year,term,courseid,cname); }
        HashMap map=new HashMap();
        map.put("total",total);
        map.put("row",list);
        return map;
    }

    //3.添加教学任务
    @RequestMapping(value = "addTeaTask",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody//专门用于用户ajax请求以后的返回值
    public int addTeaTask(TeacherTask teacherTask){
        return teacherTaskService.addTeaTask(teacherTask);//=0表示添加失败，=1表示添加成功
    }

    //4.删除一条教学任务
    @RequestMapping(value="deleteTeaTask",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody//专门用于用户ajax请求以后的返回值
    public int deleteTeaTask(String course_time) {
        return teacherTaskService.deleteTeaTask(course_time);
    }

    //5.修改课程表中的课程信息
    @RequestMapping(value="updateTeaTask",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody//专门用于用户ajax请求以后的返回值
    public int updateTeaTask(String teacherid,String tname,String course_number,String course_week,String course_time) {
        return teacherTaskService.updateTeaTask(teacherid,tname,course_number,course_week,course_time);
    }

    //6.教师通过教师id查询所教课程
    @RequestMapping(value="getTaskByTeacherid",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody//专门用于用户ajax请求以后的返回值
    public List<TeacherTask>getTaskByTeacherid(String teacherid,String course_year,String term,String cname){
        return teacherTaskService.getTaskByTeacherid(teacherid,course_year,term,cname);
    }

    //7.通过查询教学班获取一门教学课程所有信息
    @RequestMapping(value = "getCoursemsg",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody//专门用于用户ajax请求以后的返回值
    public List<TeacherTask> getCoursemsg(String course_time){
        return teacherTaskService.getCoursemsg(course_time);
    }

    //8.开启学生评价
    @RequestMapping(value="updateAimOpen",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody//专门用于用户ajax请求以后的返回值
    public int updateAimOpen(String aim_onoff,String course_time) {
        return teacherTaskService.updateAimOpen(aim_onoff,course_time);
    }

    //9.关闭学生评价开关
    @RequestMapping(value="updateAimClose",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody//专门用于用户ajax请求以后的返回值
    public int updateAimClose(String aim_onoff,String course_time) {
        return teacherTaskService.updateAimClose(aim_onoff,course_time);
    }
}
