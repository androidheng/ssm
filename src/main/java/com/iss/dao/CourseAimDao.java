package com.iss.dao;

import com.iss.entity.CourseAim;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CourseAimDao {

    //1.通过学期和课程号查询课程目标
    @Select("select * from course_aim where course_year=#{course_year} and courseid=#{courseid}")
    public List<CourseAim> getAimByCourseTime(@Param("course_year") String course_year,@Param("courseid") String courseid);


    //2通过学期、课程号、编号判断课程目标是否存在（增加课程目标时使用）
    @Select("select count(*) from course_aim where course_year=#{course_year} and courseid=#{courseid} and aimid=#{aimid}")
    public int findCourseAimByid(@Param("course_year") String course_year,@Param("courseid") String courseid,@Param("aimid") String aimid);

    //3添加课程目标
    @Insert("INSERT INTO course_aim VALUE (null,#{course_year},#{courseid},#{cname},#{course_hours},#{aimid},#{aim})")
    public int addCourseAim(CourseAim courseAim);

    //4.删除一条课程目标
    @Delete("delete from course_aim where course_year=#{course_year} and courseid=#{courseid} and aimid=#{aimid}")
    public int deleteCourseAim(@Param("course_year") String course_year,@Param("courseid") String courseid,@Param("aimid") String aimid);

    //5.修改一条课程目标
    @Update("update course_aim set aim=#{aim} where course_year=#{course_year} and courseid=#{courseid} and aimid=#{aimid} ")
    public int updateCourseAim(@Param("aim")String aim,@Param("course_year")String course_year,@Param("courseid")String courseid,@Param("aimid")String aimid);
}
