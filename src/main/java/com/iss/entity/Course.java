package com.iss.entity;

public class Course {

    String courseid;
    String cname;
    String classification;
    String credit;
    String course_hours;
    String course_college;

    @Override
    public String toString() {
        return "Course{" +
                "courseid='" + courseid + '\'' +
                ", cname='" + cname + '\'' +
                ", classification='" + classification + '\'' +
                ", credit='" + credit + '\'' +
                ", course_hours='" + course_hours + '\'' +
                ", course_college='" + course_college + '\'' +
                '}';
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

    public String getCourse_hours() {
        return course_hours;
    }

    public void setCourse_hours(String course_hours) {
        this.course_hours = course_hours;
    }

    public String getCourse_college() {
        return course_college;
    }

    public void setCourse_college(String course_college) {
        this.course_college = course_college;
    }
}
