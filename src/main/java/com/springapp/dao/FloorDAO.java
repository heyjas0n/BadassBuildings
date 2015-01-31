package com.springapp.dao;

import com.springapp.bo.Floor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by jnguyen on 1/28/2015.
 */

public class FloorDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    public void startConnection(){
        emf = Persistence.createEntityManagerFactory("defaultPersistenceUnit");
        em = emf.createEntityManager();
        em.getTransaction().begin();
    }

    public void closeConnection(){
        em.getTransaction().commit();
        System.out.println("Committing transanction and closing connection!");
        emf.close();
    }

    public void save(Floor floor){
        em.persist(floor);
    }

    public void edit(Floor floor){
        em.merge(floor);
    }

    public Floor find(long floorId){
        return em.find(Floor.class, floorId);
    }

    public void remove(Floor floor){
        em.remove(floor);
    }
}
