package ru.kravchenko.se;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.junit.Test;
import ru.kravchenko.se.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

public class UserCrudTest {

    private Lorem lorem = new LoremIpsum();

    EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ENTERPRISE");
        return emf.createEntityManager();
    }

    @Test
    public void addAnyUser() {
        for (int i = 0; i < 10; i++)  addOneUser();
    }

    public void addOneUser() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        User user = new User();
        user.setLogin(lorem.getFirstName());
        user.setPasswordHash(lorem.getUrl());
        em.persist(user);
        em.getTransaction().commit();
        em.close();
    }

    @Test
    public void findById() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        User user = em.find(User.class, "54934c47-96a2-4d5c-bfc4-e9def06ef256");
        em.close();
        System.out.println(user.getLogin());
    }

    @Test
    public void findAll() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        List<User> users = em.createQuery("SELECT e FROM User e", User.class).getResultList();
        em.close();
        System.out.println(users);
    }

    @Test
    public void removeById() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        User user = em.find(User.class, "5f89dc38-cda6-46ab-af1c-01ed1c5d6bdf");
        em.remove(user);
        em.getTransaction().commit();
        em.close();
    }

    @Test
    public void clear() { //TODO
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        em.clear();
        em.getTransaction().commit();
        em.close();
    }

    @Test
    public void findAllIds() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        List<String> users = em.createQuery("SELECT id FROM User e", String.class).getResultList();
        em.close();
        for (String s: users) System.out.println(s);
    }

    @Test
    public void findAllLogin() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        List<String> login = em.createQuery("SELECT login FROM User e", String.class).getResultList();
        em.close();
        for (String s: login) System.out.println(s);
    }

    @Test
    public void findByLogin() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        String login = "Leon";
        User user = em.createQuery("SELECT e FROM User e WHERE e.login =:login", User.class)
                .setParameter("login", login).getSingleResult();
        System.out.println(user.getPasswordHash());
        em.close();
    }

}




