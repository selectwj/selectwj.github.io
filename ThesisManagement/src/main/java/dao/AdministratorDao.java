package dao;

import entity.Administrator;

public interface AdministratorDao {



    /**
     * 根据用户名查找
     * @param username
     * @return
     */
    public Administrator queryAdministratorByUsername(String username);

    /**
     * 注册
     * @param Administrator
     * @return
     */
    public int savaAdministrator(Administrator Administrator);

    /**
     * 登录 返回null说明没有这个人
     * @param username
     * @param password
     * @return
     */
    public Administrator queryAdministratorByUsernameAndPassword(String username , String password);


}
