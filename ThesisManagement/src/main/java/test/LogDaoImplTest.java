package test;

import com.mysql.cj.log.Log;
import dao.LogDao;
import dao.impl.LogDaoImpl;
import entity.MyLog;
import org.junit.Test;

import static org.junit.Assert.*;

public class LogDaoImplTest {
    LogDao logDao = new LogDaoImpl();
    @Test
    public void writeLog() {
        MyLog log = new MyLog(0,"root","123","测试","写入日志1");
        logDao.WriteLog(log);
    }

    @Test
    public void deleteLog() {
        MyLog log = new MyLog(5,"root","123","测试","写入日志1");
        logDao.DeleteLog(log);
    }

    @Test
    public void findLogByUser() {
        String name = "root";
        System.out.println(logDao.FindLogByUser("student"));
    }

    @Test
    public void findLogByUsername() {
        String name = "root";
        System.out.println(logDao.FindLogByUsername("root"));
    }

    @Test
    public void getAllLog() {
        System.out.println(logDao.GetAllLog());
    }
}