package com.iss.dao;

import com.iss.entity.TeacherTask;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface TeacherTaskDao {

    //1.1查询教学任务
    @Select("select * from teacher_task")
    public List<TeacherTask> getAllTeaTask();

    //1.2查询教学任务数量
    @Select("select count(*) from teacher_task")
    public int getAllTeaTaskNumber();

    //1.3通过教学班判断此教学任务是否已经存在（增加时使用）
    @Select("select count(*) from teacher_task where course_time=#{course_time}")
    public int findCourseTime(@Param("course_time") String course_time);

    //2.1前端通过学年、学期、课程号、课程名称的模糊查询
    @Select("select * from teacher_task where cname like CONCAT('%',#{cname},'%') and courseid like CONCAT('%',#{courseid},'%') and term like CONCAT('%',#{term},'%') and course_year like CONCAT('%',#{course_year},'%') LIMIT #{pageIndex},#{pageSize}")
    public List<TeacherTask> getAllTeaTask1(@Param("pageIndex")int pageIndex,@Param("pageSize")int pageSize,@Param("course_year") String course_year,@Param("term") String term,@Param("courseid") String courseid,@Param("cname") String cname);

    //2.2前端通过学年、学期、课程号、课程名称的查询教学任务数量
    @Select("select count(*) from teacher_task where cname like CONCAT('%',#{cname},'%') and courseid like CONCAT('%',#{courseid},'%') and term like CONCAT('%',#{term},'%') and course_year like CONCAT('%',#{course_year},'%')")
    public int getAllTeaTaskNumber1(@Param("course_year") String course_year,@Param("term") String term,@Param("courseid") String courseid,@Param("cname") String cname);

    //3.添加一条教师任务
    @Insert("INSERT INTO teacher_task VALUE (#{course_time},#{course_year},#{term},#{courseid},#{cname},#{teacherid},#{tname},#{course_number},#{classification},#{credit},#{course_week})")
    public int addTeaTask(TeacherTask teacherTask);

    //4.删除教学任务中的某一条数据
    @Delete("delete from teacher_task where course_time=#{course_time}")
    public int deleteTeaTask(@Param("course_time")String course_time);

    //5.修改教学任务中的信息
    @Update("update teacher_task set teacherid=#{teacherid},tname=#{tname},course_number=#{course_number},course_week=#{course_week} where course_time=#{course_time}")
    public int updateTeaTask(@Param("teacherid")String teacherid,@Param("tname")String tname,@Param("course_number")String course_number,@Param("course_week")String course_week,@Param("course_time")String course_time);

    //6.教师通过教师id、(学年、学期、课程名称模糊查询)查询所教课程
    @Select("select * from teacher_task where teacherid=#{teacherid} and course_year like CONCAT('%',#{course_year},'%') and term like CONCAT('%',#{term},'%') and cname like CONCAT('%',#{cname},'%')")
    public List<TeacherTask>getTaskByTeacherid(@Param("teacherid")String teacherid,@Param("course_year")String course_year,@Param("term")String term,@Param("cname")String cname);

    //7.通过教学班查询一门课程
    @Select("select * from teacher_task where course_time=#{course_time} ")
    public List<TeacherTask>getTaskByCourseTime(@Param("course_time")String course_time);

    //8.开启学生评价开关
    @Update("update teacher_task set aim_onoff=#{aim_onoff} where course_time=#{course_time}")
    public int updateAimOpen(@Param("aim_onoff")String aim_onoff,@Param("course_time")String course_time);

    //9.关闭学生评价开关
    @Update("update teacher_task set aim_onoff=#{aim_onoff} where course_time=#{course_time}")
    public int updateAimClose(@Param("aim_onoff")String aim_onoff,@Param("course_time")String course_time);

}
