package com.example.demo.dto;

import java.io.Serializable;

/**
 * DTO for {@link com.example.demo.entities.Doctor}
 */
public class DoctorDto implements Serializable {
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private long id;

    public DoctorDto() {
    }

    public DoctorDto(String firstName, String lastName, int age, String email, long id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.email = email;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}