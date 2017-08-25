package com.webservice.app.model.bean;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.webservice.app.Utils.AppDateUtils;
import com.webservice.app.Utils.DateSerializer;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;

@Entity
@Table(name="Customer")
public class Customer extends AbstractBean {
    @Id
    @GeneratedValue
    @Column(name = "customerID")
    private Long id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "dateOfBirth", columnDefinition = "DATETIME")
    @JsonSerialize(using= DateSerializer.class)
    private Timestamp dateOfBirth;

    public Customer(long id, String firstName, String lastName, String email, String mobile) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobile = mobile;
        this.dateOfBirth = AppDateUtils.dateToTimeStamp(new Date());
    }

    public Customer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Timestamp getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Timestamp timestamp) {
        this.dateOfBirth = dateOfBirth;
    }
}
