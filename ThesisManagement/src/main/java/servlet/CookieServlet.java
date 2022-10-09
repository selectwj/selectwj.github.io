package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends BaseServlet{

    protected void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建一个性的cookie 覆盖原来的
        Cookie cookie = new Cookie("key1","value");
        resp.addCookie(cookie);

        resp.getWriter().write("cookie已修改");
    }

}
