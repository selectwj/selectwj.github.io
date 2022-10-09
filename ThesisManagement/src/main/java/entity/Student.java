package entity;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Student {
    private String username;
    private String password;
    private String name;
    private String email;
    private String phone;


    public Student(){
        this.username = "0";
        this.name = "0";
        this.password = "0";
        this.email = "0";
        this.phone = "0";



//        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        this.create_at = format.format(new Date(System.currentTimeMillis()));
    }

    /**
     *
     * @param username 用户名
     * @param password 密码
     * @param name 名字
     * @param email 邮箱
     * @param phone 电话
     */
    public Student(String username, String password, String name, String email, String phone) {
        this.username = username;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phone = phone;

//        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        this.create_at = format.format(new Date(System.currentTimeMillis()));
    }


    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
