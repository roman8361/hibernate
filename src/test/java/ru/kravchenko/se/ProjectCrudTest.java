package ru.kravchenko.se;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.junit.Test;
import ru.kravchenko.se.entity.Project;
import ru.kravchenko.se.entity.Task;
import ru.kravchenko.se.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

public class ProjectCrudTest {

    private Lorem lorem = new LoremIpsum();

    EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ENTERPRISE");
        return emf.createEntityManager();
    }

    @Test
    public void addAnyProject() {
        for (int i = 0; i < 10; i++) addOneProject();

    }

    public void addOneProject() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Project project = new Project();
        project.setName(lorem.getWords(1));
        project.setDateBegin(new Date());
        project.setDateEnd(new Date());
        project.setDescription(lorem.getWords(3));
        em.persist(project);
        em.getTransaction().commit();
        em.close();
    }

    @Test
    public void findById() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Project project = em.find(Project.class, "7ee5d4c5-761e-4aca-b8e5-175e4bb5d12c");
        em.close();
        System.out.println(project.getName());
    }

    @Test
    public void findAll() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        List<Project> projects = em.createQuery("SELECT e FROM Project e", Project.class).getResultList();
        em.close();
        System.out.println(projects);
    }

    @Test
    public void removeById() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        Project project = em.find(Project.class, "f23afa2e-2cc6-4461-883e-05aeba8824b0");
        em.remove(project);
        em.getTransaction().commit();
        em.close();
    }

    @Test
    public void findAllIds() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        List<String> project = em.createQuery("SELECT id FROM Project e", String.class).getResultList();
        em.close();
        for (String s: project) System.out.println(s);
    }

    @Test
    public void findAllProjectByUserId() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        String userId = "1";
        List<Project> projects = em.createQuery("SELECT e FROM Project e WHERE e.userId =:userId", Project.class)
                .setParameter("userId", userId)
                .getResultList();
        for (Project p: projects) System.out.println(p.getName());

    }

    @Test
    public void removeAllProjectByUserId() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        String userId = "1";
        List<Project> projects = em.createQuery("SELECT e FROM Project e WHERE e.userId =:userId", Project.class)
                .setParameter("userId", userId)
                .getResultList();
        for (Project p: projects) em.remove(p);
        em.getTransaction().commit();
        em.close();
    }

    @Test
    public void clear() {
        EntityManager em = getEntityManager();
        em.getTransaction().begin();
        List<Project> projects = em.createQuery("SELECT e FROM Project e", Project.class).getResultList();
        for (Project p: projects) em.remove(p);
        em.getTransaction().commit();
        em.close();
    }

}
