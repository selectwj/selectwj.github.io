package dao.impl;

import dao.AdministratorDao;
import dao.BaseDao;
import entity.Administrator;

public class AdministratorDaoImpl extends BaseDao implements AdministratorDao {

    @Override
    public Administrator queryAdministratorByUsername(String username) {
        String sql = "select username,password,name,email,phone from user_Administrator where username = ?";
        return queryForOne(Administrator.class,sql,username);
    }

    @Override
    public int savaAdministrator(Administrator Administrator) {
        String sql = "INSERT INTO `thesismanagement`.`user_Administrator` (`username`, `password`, `name`, `email`, `phone`) VALUES (?, ?, ?, ?, ?)";
        return update(sql,Administrator.getUsername(),Administrator.getPassword(),Administrator.getName(),Administrator.getEmail(),Administrator.getPhone());
    }

    @Override
    public Administrator queryAdministratorByUsernameAndPassword(String username, String password) {
        String sql = "select * from user_Administrator where username = ? and password = ? ";
        return queryForOne(Administrator.class,sql,username,password);
    }
}
