package ru.kravchenko.se;

import org.hibernate.Session;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import ru.kravchenko.se.entity.Project;
import ru.kravchenko.se.entity.Task;
import ru.kravchenko.se.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App {

    public static void main( String[] args )
    {
        addUser2();

    }

    static void addUser2() {
        EntityManager em = getEntityManager2();
        em.getTransaction().begin();

        User user = new User();

        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }


    static EntityManager getEntityManager2() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ENTERPRISE");
        return emf.createEntityManager();
    }

    public static EntityManager getEntityManager() {
        EntityManagerFactory emf = factory();
        return emf.createEntityManager();
    }

    static void addUser() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();

        User user = new User();

        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }

    static void deleteUser() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        User user = em.find(User.class, "5f89dc38-cda6-46ab-af1c-01ed1c5d6bdf");
        em.remove(user);
        em.getTransaction().commit();
        em.close();
    }

    static private EntityManagerFactory factory() {
        final Map<String, String> settings = new HashMap<>();
        settings.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
        settings.put(Environment.URL, "jdbc:mysql://localhost:3306/test_db");
        settings.put(Environment.USER, "root");
        settings.put(Environment.PASS, "root");
        settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5InnoDBDialect");
        settings.put(Environment.HBM2DDL_AUTO, "update");
        settings.put(Environment.SHOW_SQL, "true");
        final StandardServiceRegistryBuilder registryBuilder = new StandardServiceRegistryBuilder();
        registryBuilder.applySettings(settings); final StandardServiceRegistry registry = registryBuilder.build();
        final MetadataSources sources = new MetadataSources(registry);
        sources.addAnnotatedClass(Task.class);
        sources.addAnnotatedClass(Project.class);
        sources.addAnnotatedClass(User.class);
        sources.addAnnotatedClass(Session.class);

        final Metadata metadata = sources.getMetadataBuilder().build();
        return metadata.getSessionFactoryBuilder().build();
    }


}
