package dao;


import entity.MyLog;

import java.util.List;

public interface LogDao {
    /**
     * 写日志
     * @param log 日志对象
     * @return -1写入失败，其他为写入几条
     */
    public int WriteLog(MyLog log);

    /**
     * 删除日志
     * @param log 日志对象
     * @return
     */
    public int DeleteLog(MyLog log);

    /**
     * 根据用户类型查找用户
     * @param user 用户类型
     * @return
     */
    public List<MyLog> FindLogByUser(String user);


    /**
     * 根据用户名查找日志
     * @param username 用户名
     * @return
     */
    public List<MyLog> FindLogByUsername(String username);

    /**
     * 返回所有日志
     * @return
     */
    public List<MyLog> GetAllLog();

}
