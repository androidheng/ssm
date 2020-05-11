package com.iss.entity;

public class StuCourse {
    int id;
    String course_time;
    String course_year;
    String term;
    String courseid;
    String cname;
    String teacherid;
    String tname;
    String studentid;
    String sname;
    String sex;

    @Override
    public String toString() {
        return "StuCourse{" +
                "id=" + id +
                ", course_time='" + course_time + '\'' +
                ", course_year='" + course_year + '\'' +
                ", term='" + term + '\'' +
                ", courseid='" + courseid + '\'' +
                ", cname='" + cname + '\'' +
                ", teacherid='" + teacherid + '\'' +
                ", tname='" + tname + '\'' +
                ", studentid='" + studentid + '\'' +
                ", sname='" + sname + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCourse_time() {
        return course_time;
    }

    public void setCourse_time(String course_time) {
        this.course_time = course_time;
    }

    public String getCourse_year() {
        return course_year;
    }

    public void setCourse_year(String course_year) {
        this.course_year = course_year;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getCourseid() {
        return courseid;
    }

    public void setCourseid(String courseid) {
        this.courseid = courseid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getTeacherid() {
        return teacherid;
    }

    public void setTeacherid(String teacherid) {
        this.teacherid = teacherid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
