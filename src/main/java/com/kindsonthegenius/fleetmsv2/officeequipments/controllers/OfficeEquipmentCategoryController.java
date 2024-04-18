package com.kindsonthegenius.fleetmsv2.officeequipments.controllers;

import com.kindsonthegenius.fleetmsv2.officeequipments.models.OfficeEquipmentCategory;
import com.kindsonthegenius.fleetmsv2.officeequipments.services.OfficeEquipmentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class OfficeEquipmentCategoryController {
    @Autowired
    private OfficeEquipmentCategoryService officeEquipmentCategoryService;

    public Model addModelAttributes(Model model){

        model.addAttribute("officeEquipmentCategoryList", officeEquipmentCategoryService.findAll());

        return model;
    }

    @GetMapping("/officeequipment/equipmentcategory")
    public String equipmentCategory(Model model){
         addModelAttributes(model);
        return "officeequipment/equipmentCategory";

    }


    @PostMapping(value = "/officeequipment/equipmentcategoryAdd")
    public String addCategory(OfficeEquipmentCategory officeEquipmentCategory){

        officeEquipmentCategoryService.saveEquipmentCategory(officeEquipmentCategory);
        return "redirect:/officeequipment/equipmentcategory";
    }


    //Method to edit or view details
    @GetMapping("/officequipment1/officecategory/{op}/{id}")
    public String officeEquipmentEdit(@PathVariable int id, @PathVariable String op, Model model){
          OfficeEquipmentCategory officeEquipmentCategory = officeEquipmentCategoryService.findById(id);
         model.addAttribute("officeEquipmentCategory", officeEquipmentCategory);

        return "/officeequipment/officecategory" + op;
    }
    //Method to delete by Id
    @RequestMapping(value = "/officeCategory/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String deleById(@PathVariable int id){
       officeEquipmentCategoryService.deleteById(id);

        return "redirect:/officeequipment/equipmentcategory";
    }

}