package com.iss.service;

import com.iss.dao.CourseAimDao;
import com.iss.entity.CourseAim;
import com.iss.util.DBUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseAimService {

    //不需要实例化，自动创建对象
    @Autowired
    private CourseAimDao courseAimDao;

    //1.通过学期和课程号查询课程目标
    public List<CourseAim> getAimByCourseTime(String course_year,String courseid){
        SqlSession session= DBUtil.getSession();
        courseAimDao=session.getMapper(CourseAimDao.class);
        return courseAimDao.getAimByCourseTime(course_year,courseid);
    }

    //2.添加课程目标


    //3.删除一条课程目标
    public int deleteCourseAim(String course_year,String courseid,String aimid){
        SqlSession session= DBUtil.getSession();
        courseAimDao=session.getMapper(CourseAimDao.class);
        int x =courseAimDao.deleteCourseAim(course_year,courseid,aimid);//事务提交之后，后台数据库才会更新
        session.commit();
        return x;//=0表示没有删除成功，=1表示删除成功
    }

    //4.修改一条课程目标
    public int updateCourseAim(String aim,String course_year,String courseid,String aimid){
        SqlSession session= DBUtil.getSession();
        courseAimDao=session.getMapper(CourseAimDao.class);
        int x=courseAimDao.updateCourseAim(aim,course_year,courseid,aimid);
        session.commit();//事务提交之后，后台数据库才会更新
        return x;//=0表示没有修改成功，=1表示修改成功
    }
}
