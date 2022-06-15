package jm.task.core.jdbc;

import jm.task.core.jdbc.dao.UserDao;
import jm.task.core.jdbc.dao.UserDaoHibernateImpl;
import jm.task.core.jdbc.model.User;

public class Main {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoHibernateImpl();

        userDao.createUsersTable();

        userDao.saveUser("Name1", "LastName1", (byte) 23);
        userDao.saveUser("Name2", "LastName2", (byte) 56);
        userDao.saveUser("Name3", "LastName3", (byte) 32);
        userDao.saveUser("Name4", "LastName4", (byte) 43);

        for (User user : userDao.getAllUsers()) {
            System.out.println("User с именем – " + user.getName() + " добавлен в базу данных");
        }
        userDao.getAllUsers().forEach(System.out::println);

        userDao.cleanUsersTable();

        userDao.dropUsersTable();
    }
}
