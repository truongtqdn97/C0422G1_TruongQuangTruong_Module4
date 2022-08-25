package com.example.dto;

import org.springframework.beans.factory.annotation.Required;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;
import java.time.LocalDate;

public class UserDto implements Validator {
    @NotBlank(message = "Fill in the cell")
    @Size(min = 5, max = 45)
    private String firstName;

    @NotBlank(message = "Fill in the cell")
    @Size(min = 5, max = 45)
    private String lastName;

    @Pattern(regexp = "^(0([0-9]{9}))$", message = "Wrong format (0xxxxxxxxx)")
    private String phone;

    private String birthday;

    @NotBlank(message = "Fill in the cell")
    @Email
    private String email;

    public UserDto() {
    }

    public UserDto(String firstName, String lastName, String phone, String birthday, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.birthday = birthday;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        LocalDate birthday = null;
        if (userDto.birthday!=null){
            try{
                 birthday = LocalDate.parse(userDto.birthday);
            }catch (Exception e){
                errors.rejectValue("birthday", "create.birthday",
                        "Fill in the cell");
                return;
            }
            LocalDate now = LocalDate.now();
            int age = birthday.until(now).getYears();
            if (age<18){
                errors.rejectValue("birthday", "create.birthday",
                        "Go home and study");
            }
        }

    }
}
