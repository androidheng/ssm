package com.iss.dao;

import com.iss.entity.StuCourse1;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StuCourse1Dao {

    //1.查询全部学生选课
    @Select("select * from teacher_student_course")
    public List<StuCourse1> getAllStudentCourse();

    //2.通过学生学号查询选课
    @Select("select * from teacher_student_course where studentid=#{studentid} ")
    public List<StuCourse1> getCourseBystudentid(@Param("studentid")String studentid);

    //3.通过学生学号和当前学期查询选课！！！
    @Select("select * from teacher_student_course where studentid=#{studentid} and course_year=#{course_year} and term=#{term} ")
    public List<StuCourse1> getCourseBystudentid1(@Param("studentid")String studentid,@Param("course_year")String course_year,@Param("term")String term);

}
