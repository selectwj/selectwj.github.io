package service.impl;

import dao.AdministratorDao;
import dao.impl.AdministratorDaoImpl;
import entity.Administrator;
import service.AdministratorService;

public class AdministratorServiceImpl implements AdministratorService 
{

    private AdministratorDao AdministratorDao = new AdministratorDaoImpl();

    @Override
    public void registAdministrator(Administrator Administrator) {
        AdministratorDao.savaAdministrator(Administrator);
    }

    @Override
    public Administrator login(Administrator Administrator) {
        return AdministratorDao.queryAdministratorByUsernameAndPassword(Administrator.getUsername(),Administrator.getPassword());
    }

    @Override
    public boolean hadUsername(String username) {
        if (AdministratorDao.queryAdministratorByUsername(username)==null){
            return false;
        }
        else{
            return true;
        }
    }
}
