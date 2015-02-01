package com.springapp.bo;

import java.sql.Timestamp;

public class Customer
{
    int custId;

    public Customer(int custId,String name, int age) {
        this.name = name;
        this.custId = custId;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    String name;

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    int age;
    //getter and setter methods

}