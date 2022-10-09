package dao;

import entity.StudentMessage;

import java.util.List;

public interface StudentMessageDao {

    /**
     * 写入学生信息
     * @param message studentmessage对象
     * @return
     */
    public int WriteMessage(StudentMessage message);

    /**
     * 写入学生信息表
     * @param message studentmessage对象
     * @return
     */
    public void WriteMessageList(List<StudentMessage> message);

    /**
     * 删除学生信息
     * @param message studentmessage对象
     * @return  -1为没有这个信息 ，其他为删除成功
     */
    public int DeleteMessage(StudentMessage message);

    /**
     * 根据学号查找
     * @param message 信息对象
     * @return
     */
    public StudentMessage FindMessageByID(StudentMessage message);

    /**
     * 返回所有学生信息
     * @return
     */
    public List<StudentMessage> GetAllMessage();
}
