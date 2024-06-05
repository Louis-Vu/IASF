package org.example.controller;


import org.example.Service.VehicleService;
import org.example.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.
import java.security.Principal;

@Controller
@RequestMapping("/vehicles")
public class VehicleController {
    @Autowired
    private VehicleService vehicleService;

    @GetMapping
    public String viewCatalog(Model model, Principal principal) {
        model.addAttribute("vehicles", vehicleService.getAllVehicles());
        return "catalog";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("vehicle", new Vehicle());
        return "add-vehicle";
    }

    @PostMapping("/add")
    public String addVehicle(@Valid @ModelAttribute Vehicle vehicle, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "add-vehicle";
        }
        vehicleService.addOrUpdateVehicle(vehicle);
        return "redirect:/vehicles";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") int id, Model model) {
        Vehicle vehicle = vehicleService.getVehicleById(id);
        model.addAttribute("vehicle", vehicle);
        return "edit-vehicle";
    }

    @PostMapping("/edit/{id}")
    public String editVehicle(@PathVariable("id") int id, @Valid @ModelAttribute Vehicle vehicle, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "edit-vehicle";
        }
        vehicleService.addOrUpdateVehicle(vehicle);
        return "redirect:/vehicles";
    }

    @GetMapping("/delete/{id}")
    public String deleteVehicle(@PathVariable("id") int id) {
        vehicleService.deleteVehicle(id);
        return "redirect:/vehicles";
    }
}
