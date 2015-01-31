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

    public void setFloors(int floors) {
        this.floors = floors;
    }

    public int getFloors() {
        return floors;
    }

    //@OneToMany(mappedBy="buildingId")
    //private List<Floor> floors;
    int floors;

    public Building(){

    }
    public Building(String name, String address, int numFloors, int area) throws Exception{
        this.name = name;
        this.address = address;
        /*for(int i = 0; i < numFloors; i++){
            floors.add(new Floor(1));
        }*/
        floors= numFloors;
        this.area = area;
    }

    /*public Floor getFloor(int floorNumber) {
        if(floorNumber > 1 && floorNumber-1 <floors.size()){
                return floors.get(floorNumber-1);
        }
        return null;
    }*/
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

    /*public void setFloors(Integer numFloors) throws Exception {
        List<Floor> defaultFloors = new ArrayList<Floor>();
        for(int i = 0; i < numFloors; i++){
            defaultFloors.add(new Floor(1));
        }
        this.floors = defaultFloors;
    }*/

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }
}