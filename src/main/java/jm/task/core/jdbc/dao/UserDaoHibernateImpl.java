package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.exception.*;
import java.util.List;

public class UserDaoHibernateImpl implements UserDao {

    Util util = new Util();
    SessionFactory sessionFactory = util.getSessionFactory();
    public UserDaoHibernateImpl() {

    }


    @Override
    public void createUsersTable() {
        try(Session session = sessionFactory.openSession()) {
            var transaction =  session.beginTransaction();
            Query query = session.createNativeQuery("CREATE TABLE Users(id INT AUTO_INCREMENT" +
                    " PRIMARY KEY," +
                    "name VARCHAR(15) NOT NULL," +
                    "lastName VARCHAR(20) NOT NULL," +
                    "age TINYINT)");
            query.executeUpdate();
            transaction.commit();
        }
    }

    @Override
    public void dropUsersTable() {
        try (Session session = sessionFactory.getCurrentSession()) {
            var transaction = session.beginTransaction();
            Query query = session.createNativeQuery("DROP TABLE Users");
            query.executeUpdate();
            transaction.commit();
        } catch (SQLGrammarException e) {
            e.printStackTrace();

        }
    }

    @Override
    public void saveUser(String name, String lastName, byte age) {

    }

    @Override
    public void removeUserById(long id) {

    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public void cleanUsersTable() {

    }
}
