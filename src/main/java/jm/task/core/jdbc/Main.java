package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;


public class Main {
    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        userService.createUsersTable();
//        userService.saveUser("Stanislav", "Gorbachev", (byte) 22);
//        System.out.println("User с именем " + userService.getAllUsers().get(0).getName() +
//                " добавлен в базу данных");
//        userService.saveUser("Dasha", "Li", (byte) 24);
//        System.out.println("User с именем " + userService.getAllUsers().get(1).getName() +
//                " добавлен в базу данных");
//        userService.saveUser("Sasha", "Ivanov", (byte) 27);
//        System.out.println("User с именем " + userService.getAllUsers().get(2).getName() +
//                " добавлен в базу данных");
//        userService.saveUser("Denis", "Borodin", (byte) 25);
//        System.out.println("User с именем " + userService.getAllUsers().get(3).getName() +
//                " добавлен в базу данных");
//        userService.getAllUsers().stream().forEach(System.out::println);
//        userService.cleanUsersTable();
//        userService.dropUsersTable();

    }
}
