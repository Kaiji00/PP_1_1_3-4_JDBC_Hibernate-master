package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;


public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
        userService.saveUser("Stanislav", "Gorbachev", (byte) 22);
        userService.saveUser("Dasha", "Li", (byte) 24);
        userService.saveUser("Sasha", "Ivanov", (byte) 27);
        userService.saveUser("Denis", "Borodin", (byte) 25);
        userService.getAllUsers().stream().forEach(System.out::println);
        userService.cleanUsersTable();
        userService.dropUsersTable();
    }
}
