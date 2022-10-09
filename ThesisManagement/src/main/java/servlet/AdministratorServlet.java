package servlet;

import dao.LogDao;
import dao.impl.LogDaoImpl;
import entity.Administrator;
import entity.MyLog;
import service.AdministratorService;
import service.impl.AdministratorServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/administratorServlet")
public class AdministratorServlet extends BaseServlet {
    private AdministratorService AdministratorService = new AdministratorServiceImpl();
    private LogDao logDao = new LogDaoImpl();

    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        String name = req.getParameter("name");
        String truename = new String(name.getBytes("ISO8859_1"), "UTF-8");
        if(AdministratorService.hadUsername(username)){
            req.setAttribute("msg","注册失败，用户名已存在");
            req.setAttribute("username",username);
            req.setAttribute("email",email);
            req.setAttribute("phone",phone);
            req.setAttribute("name",name);
            MyLog myLog = new MyLog(0,"administrator",username,"注册日志","注册失败，用户名存在");
            logDao.WriteLog(myLog);
            req.getRequestDispatcher("/pages/administrators/administratorRegister.jsp").forward(req,resp);
        }else {
            AdministratorService.registAdministrator(new Administrator(username,password,truename,email,phone));
            MyLog myLog = new MyLog(0,"administrator",username,"注册日志","注册成功");
            logDao.WriteLog(myLog);
            req.getRequestDispatcher("/pages/temp/SuccessRegist.jsp").forward(req, resp);
        }
    }

    /**
     * 登录
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Administrator administrator = AdministratorService.login(new Administrator(username, password, null, null, null));
        if(administrator!=null){
            MyLog myLog = new MyLog(0,"administrator",administrator.getUsername(),"登录日志","登陆成功");
            logDao.WriteLog(myLog);
            //保存到session
            req.getSession().setAttribute("user",administrator);
            //登陆成功 跳到成功页面
            req.getRequestDispatcher("/pages/temp/SuccessLoginAdministrator.jsp").forward(req,resp);

        }else{
            //把错误信息转回去
            req.setAttribute("msg","登陆失败");
            req.setAttribute("username",username);
            MyLog myLog = new MyLog(0,"administrator",username,"登录日志","登陆失败");
            logDao.WriteLog(myLog);
            //跳回登录界面
            req.getRequestDispatcher("/pages/administrators/login_administrator.jsp").forward(req,resp);
        }
    }

    /**
     * 注销
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void logout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }

}
