package com.springapp.bo;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ROOM")
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "room_id")
    private Integer id;

    @Column(name = "number")
    private String number; //immutable

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "floor_id")
    private Floor floor; //immutable

    public Room() {
    }

    public Room(Floor floor, String number) {
        this.floor = floor;
        this.number = number;
    }

    public Floor getFloor() {
        return floor;
    }

    public Integer getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

//no setters for number, floor nor id
}