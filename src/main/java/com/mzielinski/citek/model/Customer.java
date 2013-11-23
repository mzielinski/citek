package com.mzielinski.citek.model;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

/**
 * @author mzielinski, Rule Financial
 */
public class Customer {

    @NotEmpty
    private String name;

    @Range(min = 1, max = 150)
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
