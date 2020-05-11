package com.iss.service;


import com.iss.dao.StuCourseDao;
import com.iss.entity.StuCourse;
import com.iss.util.DBUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StuCourseService {
    //不需要实例化，自动创建对象
    @Autowired
    private StuCourseDao stuCourseDao;

    //1.1查询全部学生选课
    public List<StuCourse> getAllStuCourse(){
        SqlSession session= DBUtil.getSession();
        stuCourseDao=session.getMapper(StuCourseDao.class);
        return stuCourseDao.getAllStuCourse();
    }

    //1.2查询全部学生选课的数量
    public int getAllStuCourseNumber(){
        SqlSession session= DBUtil.getSession();
        stuCourseDao=session.getMapper(StuCourseDao.class);
        return stuCourseDao.getAllStuCourseNumber();
    }

    //2.1前端通过学年、学期、课程号、学生学号的模糊查询
    public List<StuCourse>getAllStuCourse1(int pageIndex,int pageSize,String course_year,String term,String courseid,String studentid){
        SqlSession session= DBUtil.getSession();
        stuCourseDao=session.getMapper(StuCourseDao.class);
        return stuCourseDao.getAllStuCourse1(pageIndex,pageSize,course_year,term,courseid,studentid);
    }

    //2.2前端通过学年、学期、课程号、学生学号的查询学生选课数量
    public int getAllStuCourseNumber1(String course_year,String term,String courseid,String studentid){
        SqlSession session= DBUtil.getSession();
        stuCourseDao=session.getMapper(StuCourseDao.class);
        return stuCourseDao.getAllStuCourseNumber1(course_year,term,courseid,studentid);
    }

    //3.删除学生选课中的某一条数据
    public int deleteStuCourse(String course_time,String studentid){
        SqlSession session= DBUtil.getSession();
        stuCourseDao=session.getMapper(StuCourseDao.class);
        int x =stuCourseDao.deleteStuCourse(course_time,studentid);//事务提交之后，后台数据库才会更新
        session.commit();
        return x;//=0表示没有添加成功，=1表示添加成功
    }


    //4.添加文件中的数据
    public int updateStuCourse(String course_time,String course_year,String term,String courseid,
                               String cname,String teacherid,String tname,String studentid,String sname,String sex){
        SqlSession session= DBUtil.getSession();
        stuCourseDao=session.getMapper(StuCourseDao.class);
        int x=stuCourseDao.updateStuCourse(course_time,course_year,term,courseid,cname,teacherid,
                tname,studentid,sname,sex);
        session.commit();//事务提交之后，后台数据库才会更新
        return x;//=0表示没有添加成功，=1表示添加成功
    }







}
