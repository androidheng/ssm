package com.iss.controller;

import com.iss.entity.User;
import com.iss.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;

@CrossOrigin//负责跨域用的，用于ajax请求的
@Controller//必须写spring用于做解析
public class UserController {

    @Autowired
    private UserService userService;

    //获取所有用户
    @RequestMapping(value = "getAllUser",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody//专门用于用户ajax请求以后的返回值
    public List<User> getAllUser(){
        UserService userService=new UserService();
        List<User> list=userService.getAllUser();
        return list;
    }

    //登录
    @RequestMapping(value = "userLogin",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody//专门用于用户ajax请求以后的返回值
    public HashMap userLogin(String loginid,String password){
        User user1=new User();
        UserService userService=new UserService();
        int role=userService.selectUser(loginid, password);
        if (role==1){
            user1=userService.getUsermsg(loginid, password);
        }
        HashMap map=new HashMap();
        map.put("state",role);
        if (role==1){
            map.put("msg",user1);
        }else if (role==2){
            map.put("msg","用户密码错误");
        }else {
            map.put("msg","该用户不存在");
        }
        return map;
    }

    //前端通过用户id和类型查询
    @RequestMapping(value="getAllUser1",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody//专门用于用户ajax请求以后的返回值
    public HashMap getAllUser1(int pageIndex,int pageSize,String type,String userid){
        List<User> list=userService.getAllUser1(pageIndex,pageSize,type,userid);
        int total;
        if (userid.equals("%")||userid.equals("%")){ total=userService.getAllUserNumber();
        }else { total=userService.getAllUserNumber1(type,userid); }
        HashMap map=new HashMap();
        map.put("total",total);
        map.put("row",list);
        return map;
    }

    //添加用户
    @RequestMapping(value = "addUser",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody//专门用于用户ajax请求以后的返回值
    public int addUser(User user){
        return userService.addUser(user);//=0表示添加失败，=1表示添加成功
    }

    //删除用户
    @RequestMapping(value="deleteUser",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody///专门用于用户ajax请求以后的返回值
    public int deleteUser(String userid) {
        return userService.deleteUser(userid);
    }

    //修改用户信息
    @RequestMapping(value="updateUser",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody///专门用于用户ajax请求以后的返回值
    public int updateUser(String name,String loginid,String password,String type,String userid) {
        return userService.updateUser(name,loginid,password,type,userid);
    }

}
