package com.xebia.jpaexcercises._00_driver;

import com.xebia.jpaexcercises._07_id_gen.Employee;
import com.xebia.jpaexcercises._05_enum.EmployeeType;

import javax.imageio.ImageIO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

public class DbApp {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence
                .createEntityManagerFactory("jpa-examples-pu");

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Employee employee = new Employee();
//        employee.setId(1L);
//        employee.setUsername("Test Employee");
//        employee.setEmailAddress("test@gmail.com");

//        employee.setName("amit");
//        employee.setBio("hey I am a coder");

//        employee.setName("amit");
//        employee.setBio("hello world");
////        try {
////            employee.setPicture(Files.readAllBytes(Paths.get("/home/amitkumar/Documents/JavaTraining/jpa-exercises-master/src/main/java/com/xebia/jpaexcercises/_04_lob/20190625_150405.jpg")));
////        } catch (IOException e) {
////            e.printStackTrace();
////        }
//        employee.setEmployeeType(EmployeeType.CONTRACTOR);
//        employee.setDateOfBirth(new Date());
//        employee.setRegisteredAt(new Date());
//
//        entityManager.persist(employee);
//
//
//        Employee employee1 = new Employee();
////        employee1.setId(1L);
//        employee1.setName("amit");
//        employee1.setBio("hello world");
//        employee1.setEmployeeType(EmployeeType.CONTRACTOR);
//        employee1.setDateOfBirth(new Date());
//        employee1.setRegisteredAt(new Date());
//        entityManager.persist(employee1);


        entityManager.getTransaction().commit();

        Employee foundEmployee = entityManager.find(Employee.class, 1L);
//        try {
//            System.out.println( ImageIO.read(new ByteArrayInputStream(foundEmployee.getPicture())));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        System.out.println("**************************" + foundEmployee + "\ndate: " + new Date()+"sql date \n"+new java.sql.Date(1000000000));
        entityManager.close();
        entityManagerFactory.close();

    }
}
