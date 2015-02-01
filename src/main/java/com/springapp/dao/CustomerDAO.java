package com.springapp.dao;

import com.springapp.bo.Customer;

public interface CustomerDAO
{
    public void insert(Customer customer);
    public Customer findByCustomerId(int custId);
}