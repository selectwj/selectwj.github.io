package entity;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class MyLog {
    private int number;
    private String user;
    private String username;
    private String kind;
    private String content;
    private String time;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return "log{" +
                "number=" + number +
                ", user='" + user + '\'' +
                ", username='" + username + '\'' +
                ", kind='" + kind + '\'' +
                ", content='" + content + '\'' +
                ", time='" + time + '\'' +
                '}';
    }

    public MyLog() {
        this.number = 0;
        this.user = "user";
        this.username = "username";
        this.kind = "kind";
        this.content = "content";
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.time = format.format(new Date(System.currentTimeMillis()));
    }

    /**
     *
     * @param number 编号
     * @param user 用户类型
     * @param username 用户名
     * @param kind 日志类型
     * @param content 内容
     */
    public MyLog(int number, String user, String username, String kind, String content) {
        this.number = number;
        this.user = user;
        this.username = username;
        this.kind = kind;
        this.content = content;
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        this.time = format.format(new Date(System.currentTimeMillis()));
    }
}
