package servlet;


import com.google.gson.Gson;
import dao.LogDao;
import dao.StudentDao;
import dao.StudentMessageDao;
import dao.impl.LogDaoImpl;
import dao.impl.StudentDaoImpl;
import dao.impl.StudentMessageDaoImpl;
import entity.MyLog;
import entity.Student;
import entity.StudentMessage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/ajaxServlet")
public class AjaxServlet extends BaseServlet{
    LogDao logDao = new LogDaoImpl();
    StudentDao studentDao =new StudentDaoImpl();
    StudentMessageDao studentMessageDao = new StudentMessageDaoImpl();
    protected void renew(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        List<MyLog> logList = new ArrayList<MyLog>();
        logList=logDao.GetAllLog();
        Gson gson = new Gson();
        String logListString = gson.toJson(logList);
        //将json字符串传回客户端
        resp.getWriter().write(logListString);
    }
    protected void  renewStudentsTable(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        List<Student> studentList = new ArrayList<Student>();
//        List<StudentMessage> studentList;
//        studentList= studentMessageDao.GetAllMessage();
        studentList = studentDao.GetAllStudent();
        Gson gson = new Gson();
        String studentListString = gson.toJson(studentList);
        //将json字符串传回客户端
        resp.getWriter().write(studentListString);
    }
    protected void renewMessage(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
        List<StudentMessage> studentList;
        studentList= studentMessageDao.GetAllMessage();
        Gson gson = new Gson();
        String logListString = gson.toJson(studentList);
        //将json字符串传回客户端
        resp.getWriter().write(logListString);
    }

}
