package service.impl;

import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import entity.Student;
import service.StudentService;

public class StudentServiceImpl implements StudentService {

    private StudentDao studentDao = new StudentDaoImpl();

    @Override
    public void registStudent(Student student) {
        studentDao.savaStudent(student);
    }

    @Override
    public Student login(Student student) {
        return studentDao.queryStudentByUsernameAndPassword(student.getUsername(),student.getPassword());
    }

    @Override
    public boolean hadUsername(String username) {
        if (studentDao.queryStudentByUsername(username)==null){
            return false;
        }
        else{
            return true;
        }
    }
}
