package com.iss.dao;

import com.iss.entity.StuCourse;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StuCourseDao {

    //1.查询全部学生选课
    @Select("select * from student_course")
    public List<StuCourse> getAllStuCourse();

    //1.2查询教学任务数量
    @Select("select count(*) from student_course")
    public int getAllStuCourseNumber();

    //1.3通过教学班和学生学号判断此学生选课是否已经存在（增加时使用）
    @Select("select count(*) from student_course where course_time=#{course_time} and studentid=#{studentid}")
    public int findCourseTime(@Param("course_time") String course_time,@Param("studentid") String studentid);

    //2.1前端通过学年、学期、课程号、学生学号的模糊查询
    @Select("select * from student_course where studentid like CONCAT('%',#{studentid},'%') and courseid like CONCAT('%',#{courseid},'%') and term like CONCAT('%',#{term},'%') and course_year like CONCAT('%',#{course_year},'%') LIMIT #{pageIndex},#{pageSize}")
    public List<StuCourse> getAllStuCourse1(@Param("pageIndex")int pageIndex,@Param("pageSize")int pageSize,@Param("course_year") String course_year,@Param("term") String term,@Param("courseid") String courseid,@Param("studentid") String studentid);

    //2.2前端通过学年、学期、课程号、课程名称的查询学生选课数量
    @Select("select count(*) from student_course where studentid like CONCAT('%',#{studentid},'%') and courseid like CONCAT('%',#{courseid},'%') and term like CONCAT('%',#{term},'%') and course_year like CONCAT('%',#{course_year},'%')")
    public int getAllStuCourseNumber1(@Param("course_year") String course_year,@Param("term") String term,@Param("courseid") String courseid,@Param("studentid") String studentid);

    //3.删除教学任务中的某一条数据
    @Delete("delete from student_course where course_time=#{course_time} and studentid=#{studentid}")
    public int deleteStuCourse(@Param("course_time")String course_time,@Param("studentid")String studentid);

    //4.添加文件中的数据
    @Insert("INSERT INTO student_course VALUE (null,#{course_time},#{course_year},#{term},#{courseid},#{cname},#{teacherid},#{tname},#{studentid},#{sname},#{sex})")
    public int updateStuCourse(@Param("course_time")String course_time,@Param("course_year")String course_year,@Param("term")String term,@Param("courseid")String courseid,@Param("cname")String cname,@Param("teacherid")String teacherid,
                               @Param("tname")String tname,@Param("studentid")String studentid,@Param("sname")String sname,@Param("sex")String sex);


}
