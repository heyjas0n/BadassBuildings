package com.springapp.mvc;

import com.springapp.bo.Building;

import com.springapp.bo.Floor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
@RequestMapping(value = "/")
public class BuildingController {
    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private FloorRepository floorRepository;

    @RequestMapping(value = "/listBuildings", method = RequestMethod.GET)
    public ModelAndView listBuildings(@ModelAttribute("building") Building building, ModelMap result) {
        //model.addAttribute("building", new Building());
        Map<String, List<Building>> modelData = new HashMap<String, List<Building>>();
        modelData.put("buildings", buildingRepository.findAll());
        return new ModelAndView("buildingList", modelData); //sends you to buildingList.jsp
    }

    @RequestMapping(value= "/buildingSuccessfullyAdded")
    public ModelAndView addBuilding(@ModelAttribute("building") Building building) {
        //result.addAttribute(building);
        if( building != null ) {
            int numFloors = building.getNumFloors();
            ArrayList<Floor> floors = new ArrayList<Floor>();
            for(int i = 0; i < numFloors; i++){
                    floors.add(new Floor( building, "default floor name"));
            }
            building.setFloors(floors);
//            floorRepository.save(floors);

            buildingRepository.save(building);

        }
        System.out.println("Trying to add a building");
        Map<String, List<Building>> modelData = new HashMap<String, List<Building>>();
        modelData.put("buildings", buildingRepository.findAll());
        return new ModelAndView("buildingList", modelData);
    }

    @RequestMapping(value = "/addBuilding", method = RequestMethod.GET)
    public String showBuildingForm(@ModelAttribute("building") Building building, BindingResult result) {
        buildingRepository.save(building);
        return "buildingReg";
    }

    @RequestMapping("/")
    public ModelAndView defaultPage( HttpServletRequest request) {
        Date date = new Date();
        return new ModelAndView("redirect:/listBuildings");
    }

    @RequestMapping("/delete/{buildingId}")
    public String deleteBuilding(@PathVariable("buildingId") Long buildingId) {

        buildingRepository.delete(buildingRepository.findOne(buildingId));

        return "redirect:/";
    }

    @RequestMapping(value = "/editBuilding/{buildingId}", method=RequestMethod.POST)
    public ModelAndView edit(@PathVariable("buildingId") Long buildingId) {
        Building building = buildingRepository.findOne(buildingId);
        ModelMap modelData = new ModelMap();
        modelData.addAttribute(building);
        return new ModelAndView("editBuilding", modelData);
    }

    @RequestMapping(value = "/editBuilding/{buildingId}/editFloors", method=RequestMethod.POST)
    public ModelAndView editFloor(@PathVariable("buildingId") Long buildingId) {
        Building building = buildingRepository.findOne(buildingId);
        ModelMap modelData = new ModelMap();

        modelData.addAttribute(building);

        try{
            modelData.addAttribute(building.getFloors());
        }catch (Exception e){
            System.out.println("Could not get building.getFloors()!!!");
        }
        //modelData.addAttribute(floor);
        return new ModelAndView("editFloor", modelData);
    }


    @RequestMapping(value ="/saveBuilding", method=RequestMethod.POST)
    public ModelAndView save(@ModelAttribute Building b) {
        System.out.println("Trying to save "+b.getName());
        ModelAndView modelAndView = new ModelAndView("editBuilding");
        Building updatedBuilding = buildingRepository.findOne(b.getId());
        updatedBuilding.setName(b.getName());
        updatedBuilding.setAddress(b.getAddress());
        //updatedBuilding.setFloors(b.getF());

        if( b.getName().length()>0 && b.getAddress().length() > 0) {
            modelAndView.addObject("message", "Building was successfully changed.");
            buildingRepository.save(updatedBuilding);
        } else {
            modelAndView.addObject("message", "Building name and address required.");
        }

        return modelAndView;
    }

    @RequestMapping(value = "/api/buildings", method = RequestMethod.GET)
    public
    @ResponseBody
    String listUsersJson(ModelMap model) throws JSONException {
        JSONArray buildingArray = new JSONArray();
        for (Building building : buildingRepository.findAll()) {
            JSONObject buildingJSON = new JSONObject();
            buildingJSON.put("id", building.getId());
            buildingJSON.put("name", building.getName());
            buildingJSON.put("address", building.getAddress());
            buildingArray.put(buildingJSON);
        }
        return buildingArray.toString();
    }

    @PostConstruct
    public void init() {
        try{

        } catch (Exception e ) {
            System.out.println(e.getMessage());
        }
    }
}