package com.devcolybry.database;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class Person {

    private int id;
    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 0, max = 12, message = "Введите корректно возраст")
    private String name;
    @NotEmpty(message = "Возраст не должен быть пустым")
    @Min(value = 0, message = "Возраст не должен быть меньше нуля")
    private int age;
    @NotEmpty(message = "Емайл не должен быть пустым")
    @Email(message = "Емайл должен быть корректным")
    private String email;

    public Person(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public Person(){};

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return  "id = " + id +
                ", name = " + name + ", age = " + age + ", email = " + email ;
    }
}
