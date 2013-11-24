package com.mzielinski.citek.model;

import com.mzielinski.citek.enums.Gender;
import com.mzielinski.citek.validator.Phone;
import com.mzielinski.citek.validator.Year;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

/**
 * @author mzielinski, Rule Financial
 */
public class Subscriber {

    @Size(min=2, max=30)
    private String name;

    @NotEmpty
    @Email
    private String email;

    @NotNull
    @Min(13) @Max(110)
    private Integer age;

    @Phone
    private String phone;

    @NotNull
    private Gender gender;

    @DateTimeFormat(pattern="MM/dd/yyyy")
    @NotNull @Year(2010)
    private Date birthday;

    private Boolean receiveNewsletter;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Boolean getReceiveNewsletter() {
        return receiveNewsletter;
    }

    public void setReceiveNewsletter(Boolean receiveNewsletter) {
        this.receiveNewsletter = receiveNewsletter;
    }

}
