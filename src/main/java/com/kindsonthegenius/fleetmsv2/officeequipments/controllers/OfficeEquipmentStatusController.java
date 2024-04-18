package com.kindsonthegenius.fleetmsv2.officeequipments.controllers;

import com.kindsonthegenius.fleetmsv2.officeequipments.models.OfficeEquipmentStatus;
import com.kindsonthegenius.fleetmsv2.officeequipments.services.OfficeEquipmentStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OfficeEquipmentStatusController {

    @Autowired
    private OfficeEquipmentStatusService officeEquipmentStatusService;


    public Model addModelAttributes(Model model){

         model.addAttribute("statuses", officeEquipmentStatusService.findAll());

        return model;
    }


    //Method to show list of office equipment Status
    @GetMapping("/officeequipment/officestatus")
    public String officeEquipmentStatus(Model model){
         addModelAttributes(model);
        return "/officeequipment/equipmentStatus";
    }


    //Method to save
    @PostMapping("/officeequipment/statusAdd")
    public String saveNew(OfficeEquipmentStatus officeEquipmentStatus){

        officeEquipmentStatusService.save(officeEquipmentStatus);

        return "redirect:/officeequipment/equipmentStatus";

    }

    //Method to findById
    @RequestMapping("/officequipment/officeequipmentStatus/{op}/{id}")
    public String findByIdStatus(@PathVariable int id, @PathVariable String op, Model model){




        return "";
    }
}
