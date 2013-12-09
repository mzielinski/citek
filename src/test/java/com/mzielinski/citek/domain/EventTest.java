package com.mzielinski.citek.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Date;
import java.util.List;

/**
 * Illustrates use of Hibernate native APIs.
 *
 * @author Steve Ebersole
 */
public class EventTest {

    private EntityManagerFactory entityManagerFactory;

    @Before
    public void setUp() throws Exception {
        // like discussed with regards to SessionFactory, an EntityManagerFactory is set up once for an application
        // 		IMPORTANT: notice how the name here matches the name we gave the persistence-unit in persistence.xml!
        entityManagerFactory = Persistence.createEntityManagerFactory("com.mzielinski.citek.jpa");
    }

    @After
    public void tearDown() throws Exception {
        entityManagerFactory.close();
    }

    @Test
    public void basicUsage() {
        // create a couple of events...
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(new Event("Our very first event!", new Date()));
        entityManager.persist(new Event("A follow up event", new Date()));
        entityManager.getTransaction().commit();
        entityManager.close();

        // now lets pull events from the database and list them
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        List<Event> result = entityManager.createQuery( "from Event", Event.class ).getResultList();
        for ( Event event : result ) {
            System.out.println( "Event (" + event.getDate() + ") : " + event.getTitle() );
        }
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
