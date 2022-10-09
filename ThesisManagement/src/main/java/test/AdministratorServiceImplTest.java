package test;

import entity.Administrator;
import org.junit.Test;
import service.AdministratorService;
import service.impl.AdministratorServiceImpl;

import static org.junit.Assert.*;

public class AdministratorServiceImplTest {
    AdministratorServiceImpl administratorService = new AdministratorServiceImpl();

    @Test
    public void registAdministrator() {

    }

    @Test
    public void login() {
        String username = "15841826032";
        String password = "123456";
        Administrator login = administratorService.login(new Administrator(username, password, null, null, null));
        System.out.println(login);

    }

    @Test
    public void hadUsername() {
    }
}