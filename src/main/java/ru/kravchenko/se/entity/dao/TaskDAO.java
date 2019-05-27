package ru.kravchenko.se.entity.dao;

import ru.kravchenko.se.entity.Task;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 * @author Roman Kravchenko
 */

@Transactional
public class TaskDAO {

    private EntityManager em;

    public void persist (final Task task) {
        em.persist(task);
    }


}
