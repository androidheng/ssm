package com.iss.controller;


import com.iss.entity.AimResult;
import com.iss.entity.CourseAim;
import com.iss.service.AimResultService;
import com.iss.service.CourseAimService;
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
public class AimResultController {

    @Autowired
    private AimResultService aimResultService;
    private CourseAimService courseAimService;

    //
    @RequestMapping(value = "getResultNumber",method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody//专门用于用户ajax请求以后的返回值
    public HashMap getResultNumber(String course_time,String course_year,String courseid){
        List<CourseAim> list=courseAimService.getAimByCourseTime(course_year,courseid);
        List<AimResult> list1=aimResultService.getAimresultbyCourse_time(course_time);
        for (int i=0;i<list.size();i++){
            int aimid=list.get(i).getAimid();
            int total;
            total=aimResultService.getResultNumber1(course_time,aimid);
        }
        HashMap map=new HashMap();

        return map;

    }
}
