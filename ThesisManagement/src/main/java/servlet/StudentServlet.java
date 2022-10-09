package servlet;

import dao.LogDao;
import dao.impl.LogDaoImpl;
import entity.MyLog;
import entity.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/studentServlet")
public class StudentServlet extends BaseServlet {
    private StudentService studentService = new StudentServiceImpl();
    private LogDao logDao = new LogDaoImpl();

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String name = req.getParameter("name");
        String truename = new String(name.getBytes("ISO8859_1"), "UTF-8");
        if(studentService.hadUsername(username)==true){
            req.setAttribute("msg","注册失败，用户名已存在");
            req.setAttribute("username",username);
            req.setAttribute("email",email);
            req.setAttribute("phone",phone);
            req.setAttribute("name",name);
            MyLog myLog1 = new MyLog(0,"student",username,"注册日志","注册失败，用户名存在");
            logDao.WriteLog(myLog1);
            req.getRequestDispatcher("/pages/student/StudentRegister.jsp").forward(req,resp);
        }else {
            studentService.registStudent(new Student(username,password,truename,email,phone));
            MyLog myLog2 = new MyLog(0,"student",username,"注册日志","注册成功");
            logDao.WriteLog(myLog2);
            req.getRequestDispatcher("/pages/temp/SuccessRegist.jsp").forward(req, resp);
        }
    }
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(studentService.login(new Student(username,password,null,null,null))!=null){
            //登陆成功 跳到成功页面
            MyLog myLog = new MyLog(0,"student",username,"登录日志","登陆成功");
            logDao.WriteLog(myLog);
            req.getRequestDispatcher("/pages/temp/SuccessLoginStudent.jsp").forward(req,resp);
        }else{
            //把错误信息转回去
            req.setAttribute("msg","登陆失败");
            req.setAttribute("username",username);
            MyLog myLog = new MyLog(0,"student",username,"登录日志","登陆失败");
            logDao.WriteLog(myLog);
            //跳回登录界面
            req.getRequestDispatcher("/pages/student/login_student.jsp").forward(req,resp);
        }
    }
    protected void changePassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        String username = req.getParameter("usernameUser");
//        String password_old = req.getParameter("password_old_User");
//        String password_new = req.getParameter("password_new_User");
//        if(sys.UpdateUserPassword(username,password_old,password_new)>0){
//            //传回信息
//            req.setAttribute("msg","更新成功！");
//        }else{
//            //把错误信息转回去
//            req.setAttribute("msg","用户名或旧密码不正确！");
//        }
//        //跳回菜单
//        req.getRequestDispatcher("/pages/station/yizhanxuqiu.jsp").forward(req,resp);
    }

}
