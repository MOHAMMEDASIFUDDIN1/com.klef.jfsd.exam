package com.klef.jfsd.exam;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ClientDemo {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("labexamPU");
        EntityManager em = emf.createEntityManager();

        // Start Transaction
        em.getTransaction().begin();

        // Insert Device
        Device device = new Device();
        device.setBrand("Generic Brand");
        device.setModel("Generic Model");
        device.setPrice(500.00);
        em.persist(device);

       
        // Insert Smartphone
        Smartphone smartphone = new Smartphone();
        smartphone.setBrand("Apple");
        smartphone.setModel("iPhone 14");
        smartphone.setPrice(1200.00);
        smartphone.setOperatingSystem("iOS");
        smartphone.setCameraResolution(48);
        em.persist(smartphone);

        // Insert Tablet
        Tablet tablet = new Tablet();
        tablet.setBrand("Samsung");
        tablet.setModel("Galaxy Tab S9");
        tablet.setPrice(800.00);
        tablet.setScreenSize(11.0);
        tablet.setBatteryLife(12);
        em.persist(tablet);

        // Commit Transaction
        em.getTransaction().commit();

        // Close EntityManager and EntityManagerFactory
        em.close();
        emf.close();

        System.out.println("Records inserted successfully!");
    }
}
