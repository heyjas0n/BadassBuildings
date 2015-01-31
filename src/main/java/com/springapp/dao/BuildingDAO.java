package com.springapp.dao;

import com.springapp.bo.Building;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by jnguyen on 1/28/2015.
 */

public class BuildingDAO {

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

    public void save(Building building){
        em.persist(building);
    }

    public void edit(Building building){
        em.merge(building);
    }

    public Building find(long buildingId){
        return em.find(Building.class, buildingId);
    }

    public void remove(Building building){
        em.remove(building);
    }

    public List listALL(){
        return em.createNamedQuery(Building.LIST_ALL, Building.class).getResultList();
    }
}
