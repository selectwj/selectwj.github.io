package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionServlet extends BaseServlet{


    protected void createOrGetSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取或创建session对象
        HttpSession session = req.getSession();
        //是否是新创建的
        boolean isNew = session.isNew();
        //标识id
        String id = session.getId();

    }

    /**
     * 保存数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取或创建session对象
        HttpSession session = req.getSession();

        session.setAttribute("key","value");

    }

    protected void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object attribute = req.getSession().getAttribute("key");
        resp.getWriter().write("获取的数据是"+attribute);

    }

}
