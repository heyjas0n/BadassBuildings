package com.springapp.mvc;

import com.springapp.bo.Building;
import com.springapp.bo.Floor;
import com.springapp.dao.BuildingDAO;
import com.springapp.dao.FloorDAO;

import java.util.ArrayList;

public class Main {

    /**
     * @param args
     */
    public static void main(String[] args) {
        BuildingDAO buildingDAO = new BuildingDAO();
        FloorDAO floorDAO = new FloorDAO();
        buildingDAO.startConnection();
        floorDAO.startConnection();

        try {
            Building building = new Building();
            building.setName("Beethoven");
            ArrayList<Floor> floors = new ArrayList<Floor>();
            floors.add(new Floor(building, "2"));
            //building.setFloors(3);

            buildingDAO.save(building);

            // It was the first saved dog, so its id is 1
            Building persistedBuilding = buildingDAO.find(1);

            System.out.println("Name: " + persistedBuilding.getName());
            //System.out.println("Weight: " + persistedBuilding.getNumFloors());
        } catch (Exception e) {
            System.out.println("Ops, something happen: " + e.getMessage());
            e.printStackTrace();
        } finally {
            buildingDAO.closeConnection();
            floorDAO.closeConnection();

        }
    }
}