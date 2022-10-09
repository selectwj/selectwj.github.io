package service;

import entity.Administrator;

public interface AdministratorService {

    /**
     * 注册
     * @param Administrator 用户
     */
    public void registAdministrator(Administrator Administrator);

    /**
     * 登录
     * @param Administrator 用户
     * @return
     */
    public Administrator login(Administrator Administrator);

    /**
     * 检查用户名存在
     * @param username  true存在用户名
     * @return
     */
    public boolean hadUsername(String username);

}
