package service;

import entity.Student;

public interface StudentService {

    /**
     * 注册
     * @param student 用户
     */
    public void registStudent(Student student);

    /**
     * 登录
     * @param student 用户
     * @return
     */
    public Student login(Student student);

    /**
     * 检查用户名存在
     * @param username  true存在用户名
     * @return
     */
    public boolean hadUsername(String username);

}
