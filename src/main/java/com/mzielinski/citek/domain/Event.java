package com.mzielinski.citek.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "EVENTS")
public class Event {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    private Long id;

    private String title;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EVENT_DATE")
    private Date date;

    @ManyToMany
    private Set<Person> participants = new HashSet<Person>();

    public Event() {
        // this form used by Hibernate
    }

    public Event(String title, Date date) {
        this.title = title;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    private void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Person> getParticipants() {
        return participants;
    }

    public void setParticipants(Set<Person> participants) {
        this.participants = participants;
    }

}