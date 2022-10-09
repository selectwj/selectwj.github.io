package dao.impl;

import com.mysql.cj.log.Log;
import dao.BaseDao;
import dao.LogDao;
import entity.MyLog;
import entity.Student;

import java.sql.ResultSet;
import java.util.List;

public class LogDaoImpl extends BaseDao implements LogDao {
    @Override
    public int WriteLog(MyLog log) {
        String sql = "INSERT INTO `thesismanagement`.`log` (`user`, `username`, `kind`, `content`, `time`) VALUES (?, ?, ?,?, ?);";
        return update(sql,log.getUser(),log.getUsername(),log.getKind(),log.getContent(),log.getTime());
    }


    @Override
    public int DeleteLog(MyLog log) {
        String sql1 = "DELETE FROM log WHERE number = ?";
        String sql2 = "UPDATE log SET number=number-1 WHERE number > ? ";
        int flag = update(sql1,log.getNumber());
        update(sql2,log.getNumber());
        return flag;
    }

    @Override
    public List<MyLog> FindLogByUser(String user) {
        String sql = "select number,user,username,kind,content,time from log where user = ?";
        return queryForList(MyLog.class,sql,user);
    }

    @Override
    public List<MyLog> FindLogByUsername(String username) {
        String sql = "select number,user,username,kind,content,time from log where username = ?";
        return queryForList(MyLog.class,sql,username);
    }

    @Override
    public List<MyLog> GetAllLog() {
        String sql = "select number,user,username,kind,content,time from log";
        return queryForList(MyLog.class,sql);
    }
}
