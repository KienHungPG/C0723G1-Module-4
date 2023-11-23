package com.example.validate_register.dto;

import javax.validation.constraints.*;

public class UserDto {
    @NotBlank(message = "")
    @Size(min = 5, max = 45, message = "tu 5 den 45 tu")
    private String firstName;
    @NotBlank(message = "")
    @Size(min = 5, max = 45, message = "tu 5 den 45 tu")
    private String lastName;
    @Min(value = 18, message = "tuoi phai hon 18")
    private int age;

    @Pattern(regexp = "^0[0-9]{9}$", message = "Sdt phai la co dinh dang 0-XXXXXXXXX ( X la so )")
    private String phoneNumber;
    @Email(message = "phai co hau to la @gmail.com")
    private String email;

    public UserDto() {
    }

    public UserDto(String firstName, String lastName, int age, String phoneNumber, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
