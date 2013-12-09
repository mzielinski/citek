package com.mzielinski.citek;

import com.mzielinski.citek.domain.Event;
import com.mzielinski.citek.domain.Person;
import com.mzielinski.citek.uitl.HibernateUtil;
import org.hibernate.Session;

import java.util.Date;
import java.util.List;

/**
 * @author mzielinski, Rule Financial
 */
public class EventManager {

    public static void main(String[] args) {
        final EventManager mgr = new EventManager();

        // save person with events
        Person person = createPerson(mgr);
        mgr.createAndStorePerson(person);

        // show saved people
        mgr.printAllPeople();

        // clean up
        cleanUp();
    }

    private void createAndStorePerson(Person person) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        for (Event event : person.getEvents()) {
            event.getParticipants().add(person);
            session.save(event);
        }
        session.save(person);
        session.getTransaction().commit();
    }

    private static Person createPerson(EventManager mgr) {
        Person person = new Person();
        person.setFirstName("John");
        person.setLastName("Smith");
        person.setAge(28);
        person.getEmailAddresses().add("john.smith@gmail.com");
        person.getEmailAddresses().add("john.smith@yahoo.com");
        person.getEvents().add(mgr.createEvent("My Event 1", new Date()));
        person.getEvents().add(mgr.createEvent("My Event 2", new Date()));
        return person;
    }

    private Event createEvent(String title, Date theDate) {
        Event theEvent = new Event();
        theEvent.setTitle(title);
        theEvent.setDate(theDate);
        return theEvent;
    }

    @SuppressWarnings("unchecked")
    private void printAllPeople() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        List<Person> people = session.createQuery("from Person").list();
        printPerson(people);
        session.getTransaction().commit();
    }

    private static void printPerson(List<Person> persons) {
        for (Person person : persons) {
            System.out.println("First name: " + person.getFirstName() + ", last name: " + person.getLastName() + ", age: " + person.getAge());
            for (Event event : person.getEvents()) {
                System.out.println("Event: " + event.getTitle() + " Time: " + event.getDate());
            }
            for (String email : person.getEmailAddresses()) {
                System.out.println("Email: " + email);
            }
        }
    }

    private static void cleanUp() {
        HibernateUtil.getSessionFactory().close();
    }

}
