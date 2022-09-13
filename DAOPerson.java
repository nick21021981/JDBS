package com.devcolybry.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DAOPerson {
    private static final String URL = "jdbc:postgresql://localhost:5432/person";
    private static final String Login = "postgres";
    private static final String Password = "1234";
    private static Connection connection;


    static {
        try {
            connection = DriverManager.getConnection(URL, Login, Password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public Person getPersonById(int id) {
        Person person = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM Person WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            person = new Person();
            person.setId(resultSet.getInt("id"));
            person.setName(resultSet.getString("name"));
            person.setAge(resultSet.getInt("age"));
            person.setEmail(resultSet.getString("email"));
        } catch (SQLException throwables) {
            System.err.println("Пользователь с таким id не найден");
        }
        return person;
    }

    public List<Person> getAllPerson() {
        List<Person> people = new ArrayList<Person>();
        try {
            Statement statement = connection.createStatement();
            String SQL = "SELECT * FROM Person";
            ResultSet resultSet = statement.executeQuery(SQL);
            while (resultSet.next()) {
                Person person = new Person();
                person.setId(resultSet.getInt("id"));
                person.setName(resultSet.getString("name"));
                person.setAge(resultSet.getInt("age"));
                person.setEmail(resultSet.getString("email"));
                people.add(person);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return people;
    }

    public void createPeople(Person person) {
        try {
            PreparedStatement preparedstatement = connection.prepareStatement
                    ("INSERT INTO Person (name, age, email) VALUES (?, ?, ?)");
            preparedstatement.setString(1, person.getName());
            preparedstatement.setInt(2, person.getAge());
            preparedstatement.setString(3, person.getEmail());
            preparedstatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void deletePeople(Integer id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "DELETE FROM Person WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updatePeople(Person person) {
        try {
            PreparedStatement preparedstatement = connection.prepareStatement
                    ("UPDATE Person SET name = ?, age = ?, email = ? WHERE id = ?");
            preparedstatement.setString(1, person.getName());
            preparedstatement.setInt(2, person.getAge());
            preparedstatement.setString(3, person.getEmail());
            preparedstatement.setInt(4, person.getId());
            preparedstatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
