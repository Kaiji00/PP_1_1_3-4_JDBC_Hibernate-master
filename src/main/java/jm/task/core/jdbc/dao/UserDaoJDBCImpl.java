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
        Connection connection = util.getConnection();
        String sql = "CREATE TABLE Users (id INT AUTO_INCREMENT PRIMARY KEY, " +
                "name VARCHAR(15) NOT NULL, " +
                "lastName VARCHAR(20) NOT NULL, " +
                "age TINYINT)";
        try (var statement = connection.createStatement()) {
            statement.execute(sql);
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException a) {
            }
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException exc) {
                }
            }
        }
    }

    public void dropUsersTable() {
        Connection connection = util.getConnection();
        String sql = "DROP TABLE Users";
        try (var statement = connection.createStatement()) {
            statement.execute(sql);
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException exc) {
                    }
                }
            }
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        Connection connection = util.getConnection();
        String sql = "INSERT INTO Users (name, lastName, age) VALUES(?, ?, ?)";
        try (var statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.setByte(3, age);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException exc) {
                    }
                }
            }
        }
    }

    public void removeUserById(long id) {
        Connection connection = util.getConnection();
        String sql = "DELETE FROM Users WHERE ID = ?";
        try (var statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            statement.executeUpdate();
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException exc) {
                    }
                }
            }
        }
    }

    public List<User> getAllUsers() {
        Connection connection = util.getConnection();
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM Users";
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
            try {
                connection.rollback();
            } catch (SQLException ex) {
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException exc) {
                    }
                }
            }
        }
        return users;
    }

    public void cleanUsersTable() {
        Connection connection = util.getConnection();
        String sql = "TRUNCATE TABLE Users";
        try (var statement = connection.createStatement()) {
            statement.execute(sql);
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
            } finally {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (SQLException exc) {
                    }
                }
            }
        }
    }
}
