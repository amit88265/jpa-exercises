package com.xebia.jpaexcercises._10_one_to_one;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class OneToOneApp {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = null;
        EntityManager entityManager = null;
        try {
            entityManagerFactory = Persistence.createEntityManagerFactory("jpa-examples-pu");
            entityManager = entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();

            ParkingSpace parkingSpace = new ParkingSpace(123);
            ParkingSpace parkingSpace1 = new ParkingSpace(125);

            entityManager.persist(parkingSpace);
            entityManager.persist(parkingSpace1);

            Employee employee = new Employee("Test Employee", 1_000_000, parkingSpace);
            Employee employee1 = new Employee("Test Employee1", 2_000_000, parkingSpace1);

            entityManager.persist(employee);
            entityManager.persist(employee1);
            entityManager.getTransaction().commit();
            entityManager.close();


            entityManager = entityManagerFactory.createEntityManager();


            Employee foundEmployee = entityManager.find(Employee.class, employee.getId());
            System.out.println("********************************************" + foundEmployee);


            ParkingSpace foundParking = entityManager.find(ParkingSpace.class, parkingSpace.getId());

            System.out.println("**********************" + foundParking);


            entityManager.getTransaction().begin();
            entityManager.remove(foundParking);
            foundParking.getEmployee().setParkingSpace(null);

            entityManager.getTransaction().commit();
            entityManager.close();


        } catch (Exception e) {
            e.printStackTrace();
            System.exit(-1);

        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
            if (entityManagerFactory != null) {
                entityManagerFactory.close();
            }
        }

    }
}
