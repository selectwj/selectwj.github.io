package utils;

import javax.servlet.http.Cookie;



public class CookieUtils {
    /**
     * 找cookie
     * @param name    要找的名字
     * @param cookies cookie数组
     * @return null为没有
     */
    public static Cookie findCookie(String name,Cookie[] cookies){
        if(name==null||cookies==null||cookies.length==0){
            return null;
        }
        for (int i = 0; i < cookies.length; i++) {
            if (name.equals(cookies[i].getName())){
                return cookies[i];
            }
        }
        return null;
    }
}
