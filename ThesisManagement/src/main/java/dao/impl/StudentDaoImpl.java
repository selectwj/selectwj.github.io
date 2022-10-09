package dao.impl;

import dao.BaseDao;
import dao.StudentDao;
import entity.MyLog;
import entity.Student;

import java.util.List;

public class StudentDaoImpl extends BaseDao implements StudentDao {

    @Override
    public Student queryStudentByUsername(String username) {
        String sql = "select username,password,name,email,phone from user_student where username = ?";
        return queryForOne(Student.class,sql,username);
    }

    @Override
    public int savaStudent(Student student) {
        String sql = "INSERT INTO `thesismanagement`.`user_student` (`username`, `password`, `name`, `email`, `phone`) VALUES (?, ?, ?, ?, ?)";
        return update(sql,student.getUsername(),student.getPassword(),student.getName(),student.getEmail(),student.getPhone());
    }

    @Override
    public Student queryStudentByUsernameAndPassword(String username, String password) {
        String sql = "select * from user_student where username = ? and password = ? ";
        return queryForOne(Student.class,sql,username,password);
    }

    @Override
    public List<Student> GetAllStudent() {
        String sql = "select * from user_student";
        return queryForList(Student.class,sql);
    }
}
