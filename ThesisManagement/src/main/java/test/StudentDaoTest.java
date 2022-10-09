package test;

import dao.StudentDao;
import dao.impl.StudentDaoImpl;
import entity.Student;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentDaoTest {
    StudentDao studentDao = new StudentDaoImpl();
    @Test
    public void queryStudentByUsername() {

        System.out.println(studentDao.queryStudentByUsername("15841826032"));
    }

    @Test
    public void savaStudent() {
        System.out.println(studentDao.savaStudent(new Student("yang","123456","yc","15841826032@163.com","15841826032")));
    }

    @Test
    public void queryStudentByUsernameAndPassword() {
        if (studentDao.queryStudentByUsernameAndPassword("15841826032","12356")==null){
            System.out.println("fail");
        }else{
            System.out.println("ok");
        }
    }

    @Test
    public void getAllLog() {
        System.out.println(studentDao.GetAllStudent());
    }
}