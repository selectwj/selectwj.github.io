package entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class StudentMessage {
    @ExcelProperty(value = "学号")
    private String studentID ;
    @ExcelProperty(value = "姓名")
    private String name;
    @ExcelProperty(value = "题目")
    private String topic;
    @ExcelProperty(value = "指导教师")
    private String teacher;

    public StudentMessage(String studentID, String name, String topic, String teacher) {

        this.studentID = studentID;
        this.name = name;
        this.topic = topic;
        this.teacher = teacher;
    }

    public StudentMessage() {
        this.studentID = "0";
        this.name = "0";
        this.topic = "0";
        this.teacher = "0";
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    @Override
    public String toString() {
        return "student_message{" +
                "studentID='" + studentID + '\'' +
                ", name='" + name + '\'' +
                ", topic='" + topic + '\'' +
                ", teacher='" + teacher + '\'' +
                '}';
    }
}
