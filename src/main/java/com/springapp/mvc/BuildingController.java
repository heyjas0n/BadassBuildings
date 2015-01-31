package com.springapp.mvc;

import com.springapp.bo.Building;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/")
public class BuildingController {
    @Autowired
    private BuildingRepository buildingRepository;
    @Autowired
    private FloorRepository floorRepository;

    @RequestMapping(value = "/listBuildings", method = RequestMethod.GET)
    public ModelAndView listBuildings() {
        //model.addAttribute("building", new Building());
        //model.addAttribute("buildings", buildingRepository.findAll());
        Map<String, List<Building>> modelData = new HashMap<String, List<Building>>();
        modelData.put("buildings", buildingRepository.findAll());
        return new ModelAndView("buildingList", modelData); //sends you to buildingList.jsp
    }

    @RequestMapping(params = "buildingAction=createForm", method = RequestMethod.POST)
    public ModelAndView showBuildingForm() {
        Building b = new Building();
        b.setName("Enter Building Name Here");
        ModelMap modelData = new ModelMap();
        modelData.addAttribute(b);
        return new ModelAndView("buildingReg", modelData);
    }

    @RequestMapping(params = "/addBuilding", method = RequestMethod.POST)
    public String addBuilding(@ModelAttribute("building") Building building, Model model) {
        if( building != null ) {
            buildingRepository.save(building);
        }
        model.addAttribute("buiding", building);
        model.addAttribute("buildings", buildingRepository.findAll());

        return "buildingList";
    }

    @RequestMapping("/")
    public ModelAndView defaultPage( HttpServletRequest request) {
        Date date = new Date();
        return new ModelAndView("redirect:/listBuildings");
    }

    /*@RequestMapping("/")
    public String sendBuildingForm(ModelMap model) {
        Building building = new Building();
        model.addAttribute("building", new Building());
        return "buildingReg";
    }*/

    /*@RequestMapping("buildingRegistration")
    public String sendBuildingForm(ModelMap model) {
        Building building = new Building();
        model.addAttribute("building", new Building());
        return "buildingReg";
    }*/

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
        //Floor floor = building.getFloor(floorNumber);
        ModelMap modelData = new ModelMap();
        modelData.addAttribute(building);
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
            buildingJSON.put("email", building.getFloors());
            buildingArray.put(buildingJSON);
        }
        return buildingArray.toString();
    }

    @PostConstruct
    public void init() {
        try{

            /*EntityManagerFactory factory ;
            factory = Persistence.createEntityManagerFactory("defaultPersistenceUnit");
            EntityManager manager = factory.createEntityManager();
            manager.getTransaction().begin();*/
            Building b = new Building("Empire State Building", "350 5th Avenue, New York, NY 10118", 102, 2768591);
            Building b2 = new Building("Sears Tower", "233 South Wacker Drive, Chicago, IL 60606", 108, 26000000);
            Building b3 = new Building("The Austonian", "233 South Wacker Drive, Chicago, IL 60606", 56, 590870);


            buildingRepository.save(b);
            buildingRepository.save(b2);
            buildingRepository.save(b3);
            //floorRepository.flush();
            //buildingRepository.
        } catch (Exception e ) {
            System.out.println(e.getMessage());
        }
    }
}