package jm.task.core.jdbc.dao;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class UserDaoJDBCImpl implements UserDao {


    private Util util = new Util();

    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        String sql = "CREATE TABLE Users (id INT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(15) NOT NULL, " +
                "lastName VARCHAR(20) NOT NULL, " +
                "age TINYINT)";
        try (Connection connection = util.getConnection()) {
            try (var statement = connection.createStatement()) {
                statement.execute(sql);
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
            }
        } catch (SQLException exc) {
        }
    }

    public void dropUsersTable() {
        String sql = "DROP TABLE Users";
        try (Connection connection = util.getConnection()) {
            try (var statement = connection.createStatement()) {
                statement.execute(sql);
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
            }
        } catch (SQLException exc) {
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String sql = "INSERT INTO Users (name, lastName, age) VALUES(?, ?, ?)";
        try (Connection connection = util.getConnection()) {
            try (var statement = connection.prepareStatement(sql)) {
                statement.setString(1, name);
                statement.setString(2, lastName);
                statement.setByte(3, age);
                statement.executeUpdate();
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
            }
        } catch (SQLException exc) {
        }
    }

    public void removeUserById(long id) {
        String sql = "DELETE FROM Users WHERE ID = ?";
        try (Connection connection = util.getConnection()) {
            try (var statement = connection.prepareStatement(sql)) {
                statement.setLong(1, id);
                statement.executeUpdate();
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
            }
        } catch (SQLException exc) {
        }
    }

    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM Users";
        try (Connection connection = util.getConnection()) {
            try (var statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sql);
                while (resultSet.next()) {
                    User user = new User();
                    user.setId(resultSet.getLong("id"));
                    user.setName(resultSet.getString("name"));
                    user.setLastName(resultSet.getString("lastName"));
                    user.setAge(resultSet.getByte("age"));
                    users.add(user);
                }
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
            }
        } catch (SQLException exc) {
        }
        return users;
    }

    public void cleanUsersTable() {
        String sql = "TRUNCATE TABLE Users";
        try (Connection connection = util.getConnection()) {
            try (var statement = connection.createStatement()) {
                statement.execute(sql);
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
            }
        } catch (SQLException ex) {
        }
    }
}
