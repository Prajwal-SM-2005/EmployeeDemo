package com.employeedemo;

import com.employeedemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

    public static void main(String[] args) {

        Configuration configuration = new Configuration()
                .configure("hibernate.cfg.xml");

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            Employee employee =
                    new Employee("Prajwal", "SM", 50000);

            session.persist(employee);

            session.getTransaction().commit();

            System.out.println("Employee saved successfully!");
            System.out.println("Generated ID: " + employee.getId());

        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}