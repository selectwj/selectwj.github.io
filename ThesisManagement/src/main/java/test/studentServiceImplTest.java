package test;

import entity.Student;
import org.junit.Test;
import service.impl.StudentServiceImpl;
import service.StudentService;

public class studentServiceImplTest {

    StudentService studentService = new StudentServiceImpl();

    @Test
    public void registStudent() {
        studentService.registStudent(new Student("1324971687","123456","yc","qq.com","15840374810"));
    }

    @Test
    public void login() {
        System.out.println(studentService.login(new Student("1324971687","123456",null,null,null)));
    }

    @Test
    public void hadUsername() {
        System.out.println(studentService.hadUsername("15841826032"));
    }
}