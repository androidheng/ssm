package com.iss.entity;

public class TeacherTask {
    String course_time;
    String course_year;
    String term;
    String courseid;
    String cname;
    String teacherid;
    String tname;
    String course_number;
    String classification;
    String credit;
    String course_week;
    int aim_onoff;

    @Override
    public String toString() {
        return "TeacherTask{" +
                "course_time='" + course_time + '\'' +
                ", course_year='" + course_year + '\'' +
                ", term='" + term + '\'' +
                ", courseid='" + courseid + '\'' +
                ", cname='" + cname + '\'' +
                ", teacherid='" + teacherid + '\'' +
                ", tname='" + tname + '\'' +
                ", course_number='" + course_number + '\'' +
                ", classification='" + classification + '\'' +
                ", credit='" + credit + '\'' +
                ", course_week='" + course_week + '\'' +
                ", aim_onoff=" + aim_onoff +
                '}';
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

    public String getCourse_number() {
        return course_number;
    }

    public void setCourse_number(String course_number) {
        this.course_number = course_number;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getCourse_week() {
        return course_week;
    }

    public void setCourse_week(String course_week) {
        this.course_week = course_week;
    }

    public int getAim_onoff() {
        return aim_onoff;
    }

    public void setAim_onoff(int aim_onoff) {
        this.aim_onoff = aim_onoff;
    }
}
