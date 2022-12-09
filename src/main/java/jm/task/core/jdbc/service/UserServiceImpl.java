package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class UserServiceImpl implements UserService, UserDao {

    private static final Logger LOGGER = Logger.getLogger(UserServiceImpl.class.getName());

    UserDao userDao = new UserDaoJDBCImpl();

    public void createUsersTable() {
        userDao.createUsersTable();
        LOGGER.log(Level.INFO, "Table Users has been created");
    }

    public void dropUsersTable() {
        userDao.dropUsersTable();
        LOGGER.log(Level.INFO, "Table Users has been deleted");
    }

    public void saveUser(String name, String lastName, byte age) {
        userDao.saveUser(name, lastName, age);
        LOGGER.log(Level.INFO, "User " + name + " " + lastName +
                " was added to the table");
    }

    public void removeUserById(long id) {
        userDao.removeUserById(id);
        LOGGER.log(Level.INFO, "User " + id + " has been deleted");
    }

    public List<User> getAllUsers() {
        LOGGER.log(Level.INFO, "All users:");
        return userDao.getAllUsers();
    }

    public void cleanUsersTable() {
        userDao.cleanUsersTable();
        LOGGER.log(Level.INFO, "Table cleared");
    }
}
