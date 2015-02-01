package com.springapp.common;

import com.springapp.bo.Customer;
import com.springapp.dao.CustomerDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by jnguyen on 1/31/2015.
 */
public class App {
    public static void main( String[] args )
    {
        System.out.println(App.class.getResource("App.class"));
        ApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        CustomerDAO customerDAO = (CustomerDAO) context.getBean("customerDAO");
        Customer customer = new Customer(1, "Jason",28);
        customerDAO.insert(customer);

        Customer customer1 = customerDAO.findByCustomerId(1);
        System.out.println(customer1);

    }
}
