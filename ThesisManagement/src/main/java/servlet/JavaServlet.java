package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class JavaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //请求参数打印在控制台
        String username = req.getParameter("username");

        String password = req.getParameter("password");
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        //重定向到hello
        req.getRequestDispatcher("/hello.jsp").forward(req, resp);
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int type = Integer.parseInt(req.getParameter("type"));
        String kind = "";
        double area = 0;
        double Perimeter = 0;
        if(type == 1){
            kind = "圆";
            double radius = Double.parseDouble(req.getParameter("radius"));
            area = radius*radius*3.14;
            Perimeter = 2*3.14*radius;
        }else{
            kind ="矩形";
            double length = Double.parseDouble(req.getParameter("length"));
            double width = Double.parseDouble(req.getParameter("width"));
            area = length*width;
            Perimeter = 2*(width+length);
        }
        req.getSession().setAttribute("kind",kind);
        req.getSession().setAttribute("area",area);
        req.getSession().setAttribute("perimeter",Perimeter);
        req.getRequestDispatcher("/welcome.jsp").forward(req, resp);
    }
}
