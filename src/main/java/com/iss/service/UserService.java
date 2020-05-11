package com.iss.service;

import com.iss.dao.UserDao;
import com.iss.entity.User;
import com.iss.util.DBUtil;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    //不需要实例化，自动创建对象
    @Autowired
    private UserDao userDao;

    //1.获取所有用户
    public List<User> getAllUser(){
        SqlSession session= DBUtil.getSession();
        UserDao userDao=session.getMapper(UserDao.class);
        List<User> list=userDao.getAllUser();
        return list;
    }

    //2.查找登录用户是否在数据表中
    public int selectUser(String loginid,String password){
        SqlSession session=DBUtil.getSession();

        UserDao userDao=session.getMapper(UserDao.class);
        List<User> list=userDao.getAllUser();

        for (int i=0;i<list.size();i++){
            String Password=list.get(i).getPassword();

            if (loginid.equals(Loginid)&&password.equals(Password)){
                return 1;
            }else if (loginid.equals(Loginid)){
                return 2;
            }

        }
        return 3;//用户不存在
    }

    //3.获取用户在登录数据表中所有信息
    public  User getUsermsg(String loginid,String password){
        SqlSession session=DBUtil.getSession();
        UserDao userDao=session.getMapper(UserDao.class);
        List<User> list=userDao.getAllUser();
        User user=new User();

        for (int i=0;i<list.size();i++){
            String Userid=list.get(i).getUserid();
            String Name=list.get(i).getName();
            String Loginid=list.get(i).getLoginid();
            String Password=list.get(i).getPassword();
            String Type=list.get(i).getType();
            if (loginid.equals(Loginid)&&password.equals(Password)){
                user.setUserid(Userid);
                user.setName(Name);
                user.setLoginid(Loginid);
                user.setPassword(Password);
                user.setType(Type);
            }
        }
        return user;
    }

    //4.查询用户数量
    public int getAllUserNumber(){
        SqlSession session= DBUtil.getSession();
        userDao=session.getMapper(UserDao.class);
        return userDao.getAllUserNumber();
    }

    //5.通过用户id判断此用户是否已经存在（增加时使用）
    public int findUserid(String userid){
        SqlSession session= DBUtil.getSession();
        userDao=session.getMapper(UserDao.class);
        return userDao.findUserid(userid);
    }

    //6.前端通过用户id和类型查询
    public List<User>getAllUser1(int pageIndex,int pageSize,String type,String userid){
        SqlSession session= DBUtil.getSession();
        userDao=session.getMapper(UserDao.class);
        return userDao.getAllUser1(pageIndex,pageSize,type,userid);
    }

    //7.前端通过用户id和类型查询用户数量
    public int getAllUserNumber1(String type,String userid){
        SqlSession session= DBUtil.getSession();
        userDao=session.getMapper(UserDao.class);
        return userDao.getAllUserNumber1(type,userid);
    }

    //8.添加用户
    public int addUser(User user){
        SqlSession session= DBUtil.getSession();
        userDao=session.getMapper(UserDao.class);
        int x=userDao.findUserid(user.getUserid());//判断课程信息表中是否已经存在添加的课程
        if (x == 0){
            int A=userDao.addUser(user);
            session.commit();//事务提交之后，后台数据库才会更新,//增删改都要commit
            return A;
        }
        return 0;//=0表示没有添加成功，=1表示添加成功
    }

    //9.删除用户
    public int deleteUser(String userid){
        SqlSession session= DBUtil.getSession();
        userDao=session.getMapper(UserDao.class);
        int x =userDao.deleteUser(userid);//事务提交之后，后台数据库才会更新
        session.commit();
        return x;//=0表示没有添加成功，=1表示添加成功
    }

    //10.修改用户登录信息
    public int updateUser(String name,String loginid,String password,String type,String userid){
        SqlSession session= DBUtil.getSession();
        userDao=session.getMapper(UserDao.class);
        int x=userDao.updateUser(name,loginid,password,type,userid);
        session.commit();//事务提交之后，后台数据库才会更新
        return x;//=0表示没有添加成功，=1表示添加成功
    }
}
