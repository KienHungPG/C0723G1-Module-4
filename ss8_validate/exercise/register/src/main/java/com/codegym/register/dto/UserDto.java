package com.codegym.register.dto;

import jakarta.validation.constraints.*;


public class UserDto {
    @NotEmpty
    @Size(min = 5, max = 45, message = "required, minimum length 5, maximum 45 characters")
    private String firstName;
    @NotEmpty
    @Size(min = 5, max = 45, message = "required, minimum length 5, maximum 45 characters")
    private String lastName;
    @Pattern(regexp = "^0[0-9]{9}$", message = "The phone number must be 10 digits long, starting with 0")
    private String phoneNumber;
    @Min(value = 18, message = "Must be over the age of 18")
    private int age;
    @Email(message = "Email format is incorrect")
    private String email;

    public UserDto(String firstName, String lastName, String phoneNumber, int age, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.email = email;
    }

    public UserDto() {
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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
}
