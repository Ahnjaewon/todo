package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcConnection {

    private final String url = "jdbc:mysql://localhost:3306/todo"+
                               "?serverTimezone=Asia/Seoul&characterEncoding=UTF-8";
    private final String user = "root";
    private final String password = "1q2w3e4r!!";
    public Connection getJdbc(){
        Connection conn;
        try {
            conn = DriverManager.getConnection(url,user,password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return conn;
    }
}
