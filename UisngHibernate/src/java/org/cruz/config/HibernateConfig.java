/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package org.cruz.config;

import org.cruz.Person;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author Donna
 */

public class HibernateConfig {
    public static void main(String[] args) {
        // Create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml").buildSessionFactory();
        
        // Create session
        try (Session session = factory.openSession()) {
            // Start a transaction
            session.beginTransaction();

            // Create a Person object
            Person person = new Person();
            person.setFirstName("John");
            person.setLastName("Doe");
            
            // Save the Person object
            session.save(person);

            // Commit transaction
            session.getTransaction().commit();
        } finally {
            factory.close();
        }
    }
}

