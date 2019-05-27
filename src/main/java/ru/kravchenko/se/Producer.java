package ru.kravchenko.se;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.transaction.TransactionScoped;

/**
 * @author Roman Kravchenko
 */

public class Producer {

    private static final String UNIT_NAME = "ENTERPRISE";

    @PersistenceUnit(name = UNIT_NAME)
    private EntityManagerFactory entityManagerFactory;

  //  @Produces
 //   @TransactionScoped
    public EntityManager create() { return this.entityManagerFactory.createEntityManager(); }

 //   public void dispose();

}
