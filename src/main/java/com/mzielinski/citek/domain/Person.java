package com.mzielinski.citek.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * @author mzielinski, Rule Financial
 */
@Entity
@Table(name = "PEOPLE")
public class Person {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    private int age;

    private String firstName;

    private String lastName;

    @ManyToMany
    private Set<Event> events = new HashSet<Event>();

    @Column(name = "EMAIL_ADDR")
    @ElementCollection(targetClass=String.class)
    private Set<String> emailAddresses = new HashSet<String>();

    public Person() {}

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Event> getEvents() {
        return events;
    }

    public void setEvents(Set<Event> events) {
        this.events = events;
    }

    public Set<String> getEmailAddresses() {
        return emailAddresses;
    }

    public void setEmailAddresses(Set<String> emailAddresses) {
        this.emailAddresses = emailAddresses;
    }

}
