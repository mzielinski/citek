package com.mzielinski.citek.orm.entity;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import java.util.Date;


/**
 * Annotation configured address bean.
 * 
 * @author David Winterfeldt
 */
@Entity
public class Address extends AbstractPersistable<Integer> {

    private static final long serialVersionUID = 7851794269407495684L;

//    @NotEmpty
    private String address;

//    @NotEmpty
    private String city;

//    @NotEmpty
    private String state;

//    @NotEmpty
    private String zipPostal;

//    @NotEmpty
    private String country;

//    @NotEmpty
//    @NotNull
//    @Future
//    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date created;

    /**
     * Gets address.
     */
    public String getAddress() {
        return address;
    }

    /**
     * Sets address.
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Gets city.
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets city.
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Gets state.
     */
    public String getState() {
        return state;
    }

    /**
     * Sets state.
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Gets zip or postal code.
     */
    public String getZipPostal() {
        return zipPostal;
    }

    /**
     * Sets zip or postal code.
     */
    public void setZipPostal(String zipPostal) {
        this.zipPostal = zipPostal;
    }

    /**
     * Gets country.
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets country.
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets date created.
     */
    public Date getCreated() {
        return created;
    }

    /**
     * Sets date created.
     */
    public void setCreated(Date created) {
        this.created = created;
    }

    /**
     * Returns a string representation of the object.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(this.getClass().getName() + "-");
        sb.append("  id=" + getId());
        sb.append("  addresss=" + address);
        sb.append("  city=" + city);
        sb.append("  state=" + state);
        sb.append("  zipPostal=" + zipPostal);
        sb.append("  country=" + country);
        sb.append("  created=" + created);

        return sb.toString();
    }

}
