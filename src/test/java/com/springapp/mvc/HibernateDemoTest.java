package com.springapp.mvc;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.springapp.bo.Building;

import junit.framework.TestCase;
import org.junit.*;

import java.sql.Connection;
import java.sql.DriverManager;

public class HibernateDemoTest extends TestCase
{
    private EntityManager em;

    @Override
    protected void setUp(){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("defaultPersistenceUnit");
        em = entityManagerFactory.createEntityManager();
        try{
            Class.forName("org.hsqldb.jdbc.JDBCDriver" );
        } catch (Exception e){
            System.err.println("ERROR: failed to load HSQLDB JDBC driver.");
        }
        try {
            Connection c = DriverManager.getConnection("jdbc:hsqldb:mem:badassbuildingsdb", "sa", "");
            System.out.println(c.getCatalog());
        } catch (Exception e) {
            System.err.println("Connection failed");
            e.printStackTrace();
            return;
        }
    }
    @Before
    public void beforeEach()
    {

    }

    @After
    public void afterEach()
    {
        em.close();
    }

    @Test
    public void testSavingEntities(){
        em.getTransaction().begin();
        Building b = new Building();
        b.setName("Empire State Building");
        em.persist(b);
        em.getTransaction().commit();
        em.close();
    }
/*
    @Test
    public void testAutoIncrement()
    {
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();

        Building object0 = new Building();
        Building object1 = new Building();

        // IDs start as null
        Assert.assertEquals((Long) null, object0.getId());
        Assert.assertEquals((Long) null, object1.getId());

        em.persist(object0);
        em.persist(object1);

        transaction.commit();

        System.out.println("Object 0");
        System.out.println("Generated ID is: " + object0.getId());
        System.out.println("Generated Version is: " + object0.getName());

        System.out.println("Object 1");
        System.out.println("Generated ID is: " + object1.getId());
        System.out.println("Generated Version is: " + object1.getName());

        Assert.assertEquals((Long) 1l, object0.getId());
        Assert.assertEquals((Long) 2l, object1.getId());
    }*/
}