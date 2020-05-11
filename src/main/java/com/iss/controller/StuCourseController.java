package com.iss.controller;

import com.iss.entity.StuCourse;
import com.iss.service.StuCourseService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@CrossOrigin//负责跨域用的，用于ajax请求的
@Controller//必须写spring用于做解析
public class StuCourseController {

    @Autowired
    private StuCourseService stuCourseService;

    //1.1查询全部学生选课
    @RequestMapping(value="getAllStuCourse",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody//专门用于用户ajax请求以后的返回值
    public List<StuCourse> getAllStuCourse(){
        return stuCourseService.getAllStuCourse();
    }

    //2前端通过学年、学期、课程号、学生学号的模糊查询
    @RequestMapping(value="getAllStuCourse1",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody//专门用于用户ajax请求以后的返回值
    public HashMap getAllStuCourse1(int pageIndex, int pageSize, String course_year, String term, String courseid, String studentid){
        List<StuCourse> list=stuCourseService.getAllStuCourse1(pageIndex,pageSize,course_year,term,courseid,studentid);
        int total;
        if (course_year.equals("%")||term.equals("%")||courseid.equals("%")||studentid.equals("%")){ total=stuCourseService.getAllStuCourseNumber();
        }else { total=stuCourseService.getAllStuCourseNumber1(course_year,term,courseid,studentid); }
        HashMap map=new HashMap();
        map.put("total",total);
        map.put("row",list);
        return map;
    }

    //3.删除一条学生选课
    @RequestMapping(value="deleteStuCourse",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody//专门用于用户ajax请求以后的返回值
    public int deleteStuCourse(String course_time,String studentid) {
        return stuCourseService.deleteStuCourse(course_time,studentid);
    }

    //4.上传文件
    @RequestMapping(value="upfileStuCourse",method = {RequestMethod.GET,RequestMethod.POST})
    @ResponseBody//专门用于用户ajax请求以后的返回值
    public int upfileStuCourse(@RequestParam(value = "stuCourseFile") MultipartFile file, HttpServletRequest request, JEditorPane response){
        int s=0;
        try {
            //找到服务器端upload文件夹
            String path=request.getSession().getServletContext().getRealPath("upload");
            System.out.println(path);//打印文件请求路径

            String name= file.getOriginalFilename(); //得到文件名
            File nfile = new File(path);   //如果文件不存在则创建文件夹
            if(!nfile.exists()){
                nfile.mkdirs();
            }

            //检查文件是否重复,文件重复则结束进程
            File file1 = new File(path+"/"+name);
            file.transferTo(file1); //文件另存为file1

            //excel解析
            FileInputStream inputStream = new FileInputStream(file1);
            Workbook wb = null;
            if(name.endsWith("xlsx")){
                wb= new XSSFWorkbook(inputStream);
            }else if (name.endsWith("xls")){
                wb= new HSSFWorkbook(inputStream);
            }else{
                s=1;
            }

            //从excel找到第一个sheet页
            Sheet sheet = wb.getSheetAt(0);
            //excel从第一行读到最后一行，放入rows
            Iterator<Row> rows = sheet.rowIterator();
            //跳过第一行列头
            rows.next();
            while (rows.hasNext()){//每次读一行
                Row row= rows.next();
                //将单元格格式都变为String类型,getCell单元格
                for(Cell cell:row){
                    cell.setCellType(CellType.STRING);
                }
                //int id =Integer.parseInt( row.getCell(0).getStringCellValue());
                String course_time = row.getCell(0).getStringCellValue();
                String course_year = row.getCell(1).getStringCellValue();
                String term = row.getCell(2).getStringCellValue();
                String courseid = row.getCell(3).getStringCellValue();
                String cname = row.getCell(4).getStringCellValue();
                String teacherid = row.getCell(5).getStringCellValue();
                String tname = row.getCell(6).getStringCellValue();
                String studentid = row.getCell(7).getStringCellValue();
                String sname = row.getCell(8).getStringCellValue();
                String sex = row.getCell(9).getStringCellValue();

                stuCourseService.updateStuCourse(course_time,course_year,term,courseid,cname,teacherid,
                        tname,studentid,sname,sex);
            }
            s=2;
            System.out.println(s);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        System.out.println(s);
        response.setContentType("text/html; charset=UTF-8");
        return s;
    }
}
