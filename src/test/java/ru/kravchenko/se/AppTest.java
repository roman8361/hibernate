package ru.kravchenko.se;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import ru.kravchenko.se.entity.Project;
import ru.kravchenko.se.entity.Status;
import ru.kravchenko.se.entity.User;

import java.util.List;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private Lorem lorem = new LoremIpsum();

    private SessionFactory factory = new Configuration()
            .configure("hibernate.cfg.xml")
            .addAnnotatedClass(User.class)
            .buildSessionFactory();

    private Session session;

    @Test
    public void tesrFisunov1() {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Project.class)
                .buildSessionFactory();
        Session session = null;

        try {
            session = factory.getCurrentSession();
            Project project = new Project();
            project.setName("NEW PROJECT");

            session.beginTransaction();
            session.save(project);
            session.getTransaction().commit();

        }finally {
            session.close();
            factory.close();
        }
    }

    @Test
    public void addManyToBD() {
        for (int i = 0; i < 10; i++) {
            testAddToDB();
        }
    }

    public void testAddToDB() {
        try {
            final SessionFactory factory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(User.class)
                    .buildSessionFactory();

            final Lorem lorem = new LoremIpsum();

            final Session session = factory.getCurrentSession();
            User user = new User();
            user.setLogin(lorem.getFirstName());
            user.setPasswordHash(lorem.getZipCode());

            session.beginTransaction();
            session.save(user);
            session.getTransaction().commit();

        }finally {
            session.close();
            factory.close();
        }
    }

    @Test
    public void findById() {
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            User user = session.get(User.class, "6d733ebb-eb44-455d-8a92-327ed6e90392");
            Status status = user.getRole();
            System.out.println(status);
        } finally {
            session.close();
            factory.close();
        }
    }

    @Test
    public void update() {
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            User user = session.get(User.class, "6d733ebb-eb44-455d-8a92-327ed6e90392");
            user.setLogin("demon");
            session.getTransaction().commit();
        } finally {
            session.close();
            factory.close();
        }
    }

    @Test
    public void removeById() {
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();
            User user = session.get(User.class, "6d733ebb-eb44-455d-8a92-327ed6e90392");
            session.delete(user);
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

    @Test
    public void  findAllUser() {
        try {
            session = factory.getCurrentSession();
            session.beginTransaction();

            List<User> allUser = session.createQuery("from User").getResultList();
            session.getTransaction().commit();
        } finally {
            session.close();
        }
    }

}
