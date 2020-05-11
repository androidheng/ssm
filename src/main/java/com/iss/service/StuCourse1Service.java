package com.iss.service;

import com.iss.dao.StuCourse1Dao;
import com.iss.entity.StuCourse1;
import com.iss.util.DBUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuCourse1Service {

    //不需要实例化，自动创建对象
    @Autowired
    private StuCourse1Dao stuCourse1Dao;

    //1.查询全部学生选课(学生)
    public List<StuCourse1> getAllStudentCourse(){
        SqlSession session= DBUtil.getSession();
        stuCourse1Dao=session.getMapper(StuCourse1Dao.class);
        return stuCourse1Dao.getAllStudentCourse();
    }

    //2.通过学生学号查询选课
    public  List<StuCourse1> getCourseBystudentid(String studentid){
        SqlSession session= DBUtil.getSession();
        stuCourse1Dao=session.getMapper(StuCourse1Dao.class);
        return stuCourse1Dao.getCourseBystudentid(studentid);
    }

    //3.通过学生学号和当前学期查询选课！！！
    public  List<StuCourse1> getCourseBystudentid1(String studentid,String course_year,String term){
        SqlSession session= DBUtil.getSession();
        stuCourse1Dao=session.getMapper(StuCourse1Dao.class);
        return stuCourse1Dao.getCourseBystudentid1(studentid,course_year,term);
    }
}
