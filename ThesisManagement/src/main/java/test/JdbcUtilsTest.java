package test;

import org.junit.Test;
import utils.JdbcUtils;

import java.sql.Connection;

public class JdbcUtilsTest {
    @Test
    public void testJdbc(){
        for (int i = 0; i < 100; i++) {
            Connection connection = JdbcUtils.getConnection();
            System.out.println(connection);
            JdbcUtils.close(connection);
        }

    }
}
