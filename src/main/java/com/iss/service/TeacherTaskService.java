package com.iss.service;

import com.iss.dao.TeacherTaskDao;
import com.iss.entity.TeacherTask;
import com.iss.util.DBUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherTaskService {

    //不需要实例化，自动创建对象
    @Autowired
    private TeacherTaskDao teacherTaskDao;

    //1.1查询全部教学任务
    public List<TeacherTask> getAllTeaTask(){
        SqlSession session= DBUtil.getSession();
        teacherTaskDao=session.getMapper(TeacherTaskDao.class);
        return teacherTaskDao.getAllTeaTask();
    }

    //1.2查询全部教学任务的数量
    public int getAllCourseNumber(){
        SqlSession session= DBUtil.getSession();
        teacherTaskDao=session.getMapper(TeacherTaskDao.class);
        return teacherTaskDao.getAllTeaTaskNumber();
    }

    //1.3通过教学班判断此教学任务是否已经存在（增加时使用）
    public int findCourseTime(String course_time){
        SqlSession session= DBUtil.getSession();
        teacherTaskDao=session.getMapper(TeacherTaskDao.class);
        return teacherTaskDao.findCourseTime(course_time);
    }

    //2.1前端通过学年、学期、课程号、课程名称查询教学任务
    public List<TeacherTask>getAllTeaTask1(int pageIndex,int pageSize,String course_year,String term,String courseid,String cname){
        SqlSession session= DBUtil.getSession();
        teacherTaskDao=session.getMapper(TeacherTaskDao.class);
        return teacherTaskDao.getAllTeaTask1(pageIndex,pageSize,course_year,term,courseid,cname);
    }

    //2.2前端通过学年、学期、课程号、课程名称查询教学任务数量
    public int getAllTeaTaskNumber1(String course_year,String term,String courseid,String cname){
        SqlSession session= DBUtil.getSession();
        teacherTaskDao=session.getMapper(TeacherTaskDao.class);
        return teacherTaskDao.getAllTeaTaskNumber1(course_year,term,courseid,cname);
    }

    //3.添加教学任务
    public int addTeaTask(TeacherTask teacherTask){
        SqlSession session= DBUtil.getSession();
        teacherTaskDao=session.getMapper(TeacherTaskDao.class);
        int x=teacherTaskDao.findCourseTime(teacherTask.getCourse_time());//判断教学任务是否已经存在
        if (x == 0){
            int A=teacherTaskDao.addTeaTask(teacherTask);
            session.commit();//事务提交之后，后台数据库才会更新,//增删改都要commit
            return A;
        }
        return 0;//=0表示没有添加成功，=1表示添加成功
    }

    //4.删除一条教学任务
    public int deleteTeaTask(String course_time){
        SqlSession session= DBUtil.getSession();
        teacherTaskDao=session.getMapper(TeacherTaskDao.class);
        int x =teacherTaskDao.deleteTeaTask(course_time);//事务提交之后，后台数据库才会更新
        session.commit();
        return x;//=0表示没有添加成功，=1表示添加成功
    }

    //5.修改教学任务
    public int updateTeaTask(String teacherid,String tname,String course_number,String course_week,String course_time){
        SqlSession session= DBUtil.getSession();
        teacherTaskDao=session.getMapper(TeacherTaskDao.class);
        int x=teacherTaskDao.updateTeaTask(teacherid,tname,course_number,course_week,course_time);
        session.commit();//事务提交之后，后台数据库才会更新
        return x;//=0表示没有添加成功，=1表示添加成功
    }

    //6.教师通过教师id查询所教课程
    public  List<TeacherTask> getTaskByTeacherid(String teacherid,String course_year,String term,String cname){
        SqlSession session= DBUtil.getSession();
        teacherTaskDao=session.getMapper(TeacherTaskDao.class);
        return teacherTaskDao.getTaskByTeacherid(teacherid,course_year,term,cname);
    }

    //7.通过查询教学班获取一门教学课程所有信息
    public List<TeacherTask> getCoursemsg(String course_time){
        SqlSession session= DBUtil.getSession();
        teacherTaskDao=session.getMapper(TeacherTaskDao.class);
        return teacherTaskDao.getTaskByCourseTime(course_time);
    }

    //8.开启学生评价开关
    public int updateAimOpen(String aim_onoff,String course_time){
        SqlSession session= DBUtil.getSession();
        teacherTaskDao=session.getMapper(TeacherTaskDao.class);
        int x=teacherTaskDao.updateAimOpen(aim_onoff,course_time);
        session.commit();//事务提交之后，后台数据库才会更新
        return x;//=0表示没有添加成功，=1表示添加成功
    }

    //9.关闭学生评价开关
    public int updateAimClose(String aim_onoff,String course_time){
        SqlSession session= DBUtil.getSession();
        teacherTaskDao=session.getMapper(TeacherTaskDao.class);
        int x=teacherTaskDao.updateAimClose(aim_onoff,course_time);
        session.commit();//事务提交之后，后台数据库才会更新
        return x;//=0表示没有添加成功，=1表示添加成功
    }
}
