package com.iss.dao;

import com.iss.entity.AimResult;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AimResultDao {

    //通过教学班查询所有结果
    @Select("select * from teacher_result where course_time=#{course_time}")
    public List<AimResult> getAimresultbyCourse_time(@Param("course_time") String course_time);



    //1.查询完全了解人数
    @Select("select count(*) from teacher_result where course_time=#{course_time} and aimid=#{aimid} and result=完全了解 ")
    public int getResultNumber1(@Param("course_time") String course_time,@Param("aimid") int aimid);

    //2.查询了解人数
    @Select("select count(*) from teacher_result where course_time=#{course_time} and aimid=#{aimid} and result=了解 ")
    public int getResultNumber2(@Param("course_time") String course_time,@Param("aimid") int aimid);

    //3.查询基本了解 人数
    @Select("select count(*) from teacher_result where course_time=#{course_time} and aimid=#{aimid} and result=基本了解 ")
    public int getResultNumber3(@Param("course_time") String course_time,@Param("aimid") int aimid);

    //4.查询不了解人数
    @Select("select count(*) from teacher_result where course_time=#{course_time} and aimid=#{aimid} and result=不了解 ")
    public int getResultNumber4(@Param("course_time") String course_time,@Param("aimid") int aimid);

    //4.查询完全不了解人数
    @Select("select count(*) from teacher_result where course_time=#{course_time} and aimid=#{aimid} and result=完全不了解 ")
    public int getResultNumber5(@Param("course_time") String course_time,@Param("aimid") int aimid);
}
