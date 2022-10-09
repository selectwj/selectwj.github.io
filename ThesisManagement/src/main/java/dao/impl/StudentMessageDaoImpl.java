package dao.impl;

import dao.BaseDao;
import dao.StudentMessageDao;
import entity.StudentMessage;

import java.util.List;

public class StudentMessageDaoImpl extends BaseDao implements StudentMessageDao {
    @Override
    public int WriteMessage(StudentMessage message) {
        String sql = "INSERT INTO `thesismanagement`.`student_message` (`studentID`, `name`, `topic`, `teacher`) VALUES (?, ?, ?, ?);";
        if (FindMessageByID(message)==null){
            System.out.println("可以添加");
            return update(sql,message.getStudentID(),message.getName(),message.getTopic(),message.getTeacher());
        }
        System.out.println("重复了");
        return -1;
    }

    @Override
    public void WriteMessageList(List<StudentMessage> message) {
        for (StudentMessage s:message) {
            if (FindMessageByID(s)==null){
                System.out.println("可以添加");
                WriteMessage(s);
            }
            System.out.println("重复了");

        }
    }

    @Override
    public int DeleteMessage(StudentMessage message) {
        String sql = "DELETE FROM student_message WHERE studentID = ?";
        if (FindMessageByID(message)!=null){
            System.out.println("存在这个数据");
            return update(sql,message.getStudentID());
        }
        System.out.println("不存在");
        return -1;
    }

    @Override
    public StudentMessage FindMessageByID(StudentMessage message) {
        String sql = "select studentID,name,topic,teacher from student_message where studentID = ?";
        return queryForOne(StudentMessage.class,sql,message.getStudentID());
    }

    @Override
    public List<StudentMessage> GetAllMessage() {
        String sql = "select studentID,name,topic,teacher from student_message";
        return queryForList(StudentMessage.class,sql);
    }
}
