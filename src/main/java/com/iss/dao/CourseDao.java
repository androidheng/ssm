package com.iss.dao;

import com.iss.entity.Course;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CourseDao {

    //1.1查询课程表中所有的课程信息
    @Select("select * from course")
    public List<Course> getAllCourse();

    //1.2查询课程表中所有的课程数量
    @Select("select count(*) from course")
    public int getAllCourseNumber();

    //1.3通过课程ID判断此课程是否已经存在课程表中（增加课程时使用）
    @Select("select count(*) from course where courseid=#{courseid}")
    public int findCourseByid(@Param("courseid") String courseid);

    //2.1前端通过课程ID进行课程信息的模糊查询
    @Select("select * from course where courseid like CONCAT('%',#{courseid},'%') LIMIT #{pageIndex},#{pageSize}")
    public List<Course> getAllCourse1(@Param("pageIndex")int pageIndex,@Param("pageSize")int pageSize,@Param("courseid") String courseid);

    //2.2通过课程ID模糊查询对应ID的课程数量
    @Select("select count(*) from course where courseid like CONCAT('%',#{courseid},'%')")
    public int getCourseNumberByCourseid(@Param("courseid") String courseid);

    //3.向课程数据表中添加课程信息
    @Insert("INSERT INTO course VALUE (#{courseid},#{cname},#{classification},#{credit},#{course_hours},#{course_college})")
    public int addCourse(Course course);

    //4.删除课程表中的某一条数据
    @Delete("delete from course where courseid=#{courseid}")
    public int deleteCourse(@Param("courseid")String courseid);

    //5.修改课程表中的课程信息
    @Update("update course set cname=#{cname},classification=#{classification},credit=#{credit},course_hours=#{course_hours},course_college=#{course_college} where courseid=#{courseid}")
    public int updateCourse(@Param("cname")String cname,@Param("classification")String classification,@Param("credit")String credit,@Param("course_hours")String course_hours,@Param("course_college")String course_college,@Param("courseid") String courseid);
}
