package com.springapp.bo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
@Table
//@NamedQuery(name="listALL", query="select b from Buildings b")
public class Building {

    public static final String LIST_ALL = "listALL";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String address;

    @Column
    private Integer area;

    public Integer getNumFloors() {
        return numFloors;
    }

    public void setNumFloors(Integer numFloors) {
        this.numFloors = numFloors;
    }

    @Column
    private Integer numFloors;



    @OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<Floor> floors;

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }

    public Building(){

    }
    public Building(String name, String address, int numFloors, int area) throws Exception{
        this.name = name;
        this.address = address;
        this.numFloors = numFloors;
        for(int i = 0; i < 10; i++){
            floors.add(new Floor());
        }
        this.area = area;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String lastName) {
        this.address = lastName;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }
}