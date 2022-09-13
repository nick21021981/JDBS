package com.devcolybry.database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DAOPerson daoPerson = new DAOPerson();
        String name, email;
        int id, age;
        List<Person> personList = new ArrayList<Person>();
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        while (n != 6) {
            System.out.println();
            System.out.println("----------------------------------------------------------------" +
                    "--------------------------------------------");
            System.out.println("Введите 1 - Вывести весь список;  2 - Поиск по id;  3 - Добавить;" +
                    "  4 - Обновить;  5 - Удалить;  6 - Выход");
            n = scanner.nextInt();
            if (n == 1) {
                personList = daoPerson.getAllPerson();
                for (Person person : personList) {
                    System.out.println(person.getId() + " " + person.getName() +
                            " " + person.getAge() + " " + person.getEmail());
                }
            } else if (n == 2) {
                Person person;
                System.out.println("Введите ID");
                person = daoPerson.getPersonById(scanner.nextInt());
                System.out.println(person.toString());
            } else if (n == 3) {
                System.out.println("Введите имя");
                name = scanner.next();
                System.out.println("Введите возраст");
                age = scanner.nextInt();
                System.out.println("Введите имэйл");
                email = scanner.next();
                Person person = new Person(name, age, email);
                daoPerson.createPeople(person);
            } else if (n == 4) {
                System.out.println("Введите id");
                id = scanner.nextInt();
                System.out.println("Введите имя");
                name = scanner.next();
                System.out.println("Введите возраст");
                age = scanner.nextInt();
                System.out.println("Введите имэйл");
                email = scanner.next();
                Person person = new Person(id, name, age, email);
                daoPerson.updatePeople(person);
            } else if (n == 5) {
                System.out.println("Введите ID");
                daoPerson.deletePeople(scanner.nextInt());
            }
        }
    }
}

