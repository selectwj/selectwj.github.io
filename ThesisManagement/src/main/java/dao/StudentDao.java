package dao;

import entity.MyLog;
import entity.Student;

import java.util.List;

public interface StudentDao {



    /**
     * 根据用户名查找
     * @param username
     * @return
     */
    public Student queryStudentByUsername(String username);

    /**
     * 注册
     * @param student
     * @return
     */
    public int savaStudent(Student student);

    /**
     * 登录 返回null说明没有这个人
     * @param username
     * @param password
     * @return
     */
    public Student queryStudentByUsernameAndPassword(String username , String password);

    public List<Student> GetAllStudent();

}
