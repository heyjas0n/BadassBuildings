package com.springapp.dao;

/**
 * Created by jnguyen on 1/29/2015.
 */
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil
{
    public static EntityManagerFactory getEntityManagerFactory()
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("defaultPersistenceUnit"); // String here needs to be same as persistence-unit name="defaultPersistenceUnit" in persistence.xml
        //EntityManagerFactory emf = Persistence.createEntityManagerFactory("probsnotworking"); // String here needs to be same as persistence-unit name="defaultPersistenceUnit" in persistence.xml

        return emf;
    }
}