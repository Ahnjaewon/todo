package dao;

import config.JdbcConnection;
import dto.LoginDto;
import dto.UserDto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public void insert(UserDto user) {
        Connection conn = new JdbcConnection().getJdbc();
        String sql = "insert into users(username,password,name) " +
                "values(?,?,?)";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getName());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean login(LoginDto loginDto) {
        List<UserDto> users = new ArrayList<>();
        Connection conn = new JdbcConnection().getJdbc();
        String sql = "select id,username,name,create_at " +
                     "from users " +
                     "where username = ? and password = ?";
        try {
            PreparedStatement pst = conn.prepareStatement(sql);
            pst.setString(1, loginDto.getUsername());
            pst.setString(2, loginDto.getPassword());
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                users.add(makeUser(resultSet));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users.size() != 0;
    }

    private UserDto makeUser(ResultSet resultSet) {
        try {
            int id1 = resultSet.getInt("id");
            String username = resultSet.getString("username");
            String name = resultSet.getString("name");
            String createdAt = resultSet.getString("create_at");
            return new UserDto(id1,username,name,createdAt);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
