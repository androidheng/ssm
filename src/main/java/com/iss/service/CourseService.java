package com.iss.service;

import com.iss.dao.CourseDao;
import com.iss.entity.Course;
import com.iss.util.DBUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    //不需要实例化，自动创建对象
    @Autowired
    private CourseDao courseDao;

    //1.1查询课程表中所有的课程信息
    public List<Course>getAllCourse(){
        SqlSession session= DBUtil.getSession();
        courseDao=session.getMapper(CourseDao.class);
        return courseDao.getAllCourse();
    }

    //1.2查询课程表中所有的课程数量
    public int getAllCourseNumber(){
        SqlSession session= DBUtil.getSession();
        courseDao=session.getMapper(CourseDao.class);
        return courseDao.getAllCourseNumber();
    }

    //1.3通过课程ID判断此课程是否已经存在课程表中（增加课程时使用）
    public int findCourseByid(String courseid){
        SqlSession session= DBUtil.getSession();
        courseDao=session.getMapper(CourseDao.class);
        return courseDao.findCourseByid(courseid);
    }

    //2.1前端通过课程ID进行课程信息的查询
    public List<Course>getAllCourse1(int pageIndex,int pageSize,String courseid){
        SqlSession session= DBUtil.getSession();
        courseDao=session.getMapper(CourseDao.class);
        return courseDao.getAllCourse1(pageIndex,pageSize,courseid);
    }

    //2.2前端通过课程ID进行课程信息的数量查询
    public int getCourseNumberByCourseid(String courseid){
        SqlSession session= DBUtil.getSession();
        courseDao=session.getMapper(CourseDao.class);
        return courseDao.getCourseNumberByCourseid(courseid);
    }

    //3.向课程数据表中添加课程信息
    public int addCourse(Course course){
        SqlSession session= DBUtil.getSession();
        courseDao=session.getMapper(CourseDao.class);
        int x=courseDao.findCourseByid(course.getCourseid());//判断课程信息表中是否已经存在添加的课程
        if (x == 0){
            int A=courseDao.addCourse(course);
            session.commit();//事务提交之后，后台数据库才会更新,//增删改都要commit
            return A;
        }
        return 0;//=0表示没有添加成功，=1表示添加成功
    }

    //4.删除课程表中的某一条数据
    public int deleteCourse(String courseid){
        SqlSession session= DBUtil.getSession();
        courseDao=session.getMapper(CourseDao.class);
        int x =courseDao.deleteCourse(courseid);//事务提交之后，后台数据库才会更新
        session.commit();
        return x;//=0表示没有添加成功，=1表示添加成功
    }

    //5.修改课程表中的课程信息
    public int updateCourse(String cname,String classification,String credit,String course_hours,String course_college,String courseid){
        SqlSession session= DBUtil.getSession();
        courseDao=session.getMapper(CourseDao.class);
        int x=courseDao.updateCourse(cname,classification,credit,course_hours,course_college,courseid);
        session.commit();//事务提交之后，后台数据库才会更新
        return x;//=0表示没有添加成功，=1表示添加成功
    }

}
