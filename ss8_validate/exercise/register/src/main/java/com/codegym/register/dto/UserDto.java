package com.codegym.register.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Validator {
    @NotEmpty
    @Size(min = 5, max = 45, message = "required, minimum length 5, maximum 45 characters")
    private String firstName;
    @NotEmpty
    @Size(min = 5, max = 45, message = "required, minimum length 5, maximum 45 characters")
    private String lastName;
    @Pattern(regexp = "^0[0-9]{9}$", message = "The phone number must be 10 digits long, starting with 0")
    private String phoneNumber;
    @Past(message = "Birthdate must be in the past")
    private Date birthDate;
    @Email(message = "Email format is incorrect")
    private String email;

    public boolean isOver18() {
        if (birthDate == null) {
            return false;
        }

        LocalDate dobLocalDate = birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate now = LocalDate.now();

        Period period = Period.between(dobLocalDate, now);
        return period.getYears() >= 18;
    }
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        if (userDto.getBirthDate() == null){
            errors.rejectValue("birthDate", null, "Please enter birthday");
        } else if (!userDto.isOver18()) {
            errors.rejectValue("birthDate",null,"Your age must be greater than 18 years old");
        }
    }
}
