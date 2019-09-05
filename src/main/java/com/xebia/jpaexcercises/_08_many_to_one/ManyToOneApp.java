package com.xebia.jpaexcercises._08_many_to_one;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ManyToOneApp {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("jpa-examples-pu");
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            Department department = new Department("IT");


            Employee employee = new Employee();
            employee.setName("Test Employee");
            employee.setSalary(100_000);
            employee.setDepartment(department);
            entityManager.persist(employee);

            Employee employee1 = new Employee();
            employee1.setName("John");
            employee1.setSalary(200_000);
            employee1.setDepartment(department);
            entityManager.persist(employee1);

            Employee employee2 = new Employee();
            employee2.setName("Tom");
            employee2.setSalary(300_000);
            employee2.setDepartment(department);
            entityManager.persist(employee2);






            entityManager.getTransaction().commit();
            Employee foundEmployee = entityManager.find(Employee.class, employee.getId());
            System.out.println("**************************" + foundEmployee);
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);
        } finally {
            entityManager.close();
            entityManagerFactory.close();
        }

    }
}
