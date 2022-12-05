package jm.task.core.jdbc;
import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.util.Util;

public class Main {
    public static void main(String[] args) {
        Util util = new Util();
        util.getConnection();
        UserDao userDao = new UserDaoJDBCImpl();
        userDao.createUsersTable();
        userDao.saveUser("Stanislav", "Gorbachev", (byte) 22);
        System.out.println("User с именем " + userDao.getAllUsers().get(0).getName() +
                " добавлен в базу данных");
        userDao.saveUser("Dasha", "Li", (byte) 24);
        System.out.println("User с именем " + userDao.getAllUsers().get(1).getName() +
                " добавлен в базу данных");
        userDao.saveUser("Sasha", "Ivanov", (byte) 27);
        System.out.println("User с именем " + userDao.getAllUsers().get(2).getName() +
                " добавлен в базу данных");
        userDao.saveUser("Denis", "Borodin", (byte) 25);
        System.out.println("User с именем " + userDao.getAllUsers().get(3).getName() +
                " добавлен в базу данных");
        userDao.getAllUsers().stream().forEach(System.out::println);
        userDao.cleanUsersTable();
        userDao.dropUsersTable();

    }
}
