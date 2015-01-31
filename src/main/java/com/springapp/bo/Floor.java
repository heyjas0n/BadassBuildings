package com.springapp.bo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Floor {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String number; //immutable

    @ManyToOne
    private Building building; //immutable

    public int getNumRooms() {
        return numRooms;
    }

    public void setNumRooms(int numRooms) {
        this.numRooms = numRooms;
    }

    @Basic
    private int numRooms;

    public Floor() {
    }

    public Floor(Building building, String number) {
        this.building = building;
        this.number = number;
    }
    public Building getBuilding() {
        return building;
    }

    private void setBuilding(Building building) {
        this.building = building;
    }

    public Integer getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    @PostConstruct
    public void initialize(){
        System.out.println("After bean initialization");
    }

    @PreDestroy
    public void cleanup(){
        System.out.println("Cleaning up");
    }


//no setters for number, building nor id
}