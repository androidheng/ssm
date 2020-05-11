package com.iss.service;


import com.iss.dao.AimResultDao;
import com.iss.entity.AimResult;
import com.iss.util.DBUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AimResultService {

    //不需要实例化，自动创建对象
    @Autowired
    private AimResultDao aimResultDao;

    //通过教学班查询评价结果
    public List<AimResult> getAimresultbyCourse_time(String course_time){
        SqlSession session= DBUtil.getSession();
        AimResultDao aimResultDao=session.getMapper(AimResultDao.class);
        List<AimResult> list=aimResultDao.getAimresultbyCourse_time(course_time);
        return list;
    }
    

    /*public int getResultNumber(String course_time){
        SqlSession session= DBUtil.getSession();
        aimResultDao=session.getMapper(AimResultDao.class);
        List<AimResult> list=aimResultDao.getAimresultbyCourse_time(course_time);
        for (int i=0;i<list.size();i++){
            int aimid=list.get(i).getAimid();
            if (aimid.){
                
            }
        }
    }*/

    //1.查询完全了解人数
    public  int getResultNumber1(String course_time,int aimid){
        SqlSession session= DBUtil.getSession();
        aimResultDao=session.getMapper(AimResultDao.class);
        return aimResultDao.getResultNumber1(course_time,aimid);
    }

    //2.查询了解人数
    public  int getResultNumber2(String course_time,int aimid){
        SqlSession session= DBUtil.getSession();
        aimResultDao=session.getMapper(AimResultDao.class);
        return aimResultDao.getResultNumber2(course_time,aimid);
    }

    //3.查询基本了解人数
    public  int getResultNumber3(String course_time,int aimid){
        SqlSession session= DBUtil.getSession();
        aimResultDao=session.getMapper(AimResultDao.class);
        return aimResultDao.getResultNumber3(course_time,aimid);
    }

    //4.查询不了解人数
    public  int getResultNumber4(String course_time,int aimid){
        SqlSession session= DBUtil.getSession();
        aimResultDao=session.getMapper(AimResultDao.class);
        return aimResultDao.getResultNumber4(course_time,aimid);
    }

    //5.查询完全不了解人数
    public  int getResultNumber5(String course_time,int aimid){
        SqlSession session= DBUtil.getSession();
        aimResultDao=session.getMapper(AimResultDao.class);
        return aimResultDao.getResultNumber5(course_time,aimid);
    }


}
