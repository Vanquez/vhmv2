package com.kindsonthegenius.fleetmsv2.assetm.controllers;

import com.kindsonthegenius.fleetmsv2.assetm.models.Asset;
import com.kindsonthegenius.fleetmsv2.assetm.models.AssetCategory;
import com.kindsonthegenius.fleetmsv2.assetm.services.AssetCategoryService;
import com.kindsonthegenius.fleetmsv2.assetm.services.AssetService;
import com.kindsonthegenius.fleetmsv2.fleet.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AssetController {

     @Autowired
     private AssetService assetService;
     @Autowired
     private AssetCategoryService assetCategoryService;

     public Model addModelAttributes(Model model){
         model.addAttribute("assetCategoryList", assetCategoryService.findAll());
         model.addAttribute("assetList", assetService.findAll());


        return model;
     }


     // Review assets page
     @GetMapping("/assetm/assets")
     public String findAll(Model model){
         addModelAttributes(model);
         return "assetm/Assets";
     }



      //  Endpoint to save an Asset
    @GetMapping("/assetm/assetadd")
    public String assetAdd(Model model) {
       addModelAttributes(model);
        return "/assetm/assetAdd";
    }

    // Method to save asset



    @PostMapping(  "/assetm/assets")
    public String addNew(Asset asset) {
        assetService.save(asset);
        return "redirect:/assetm/Assets";
    }


    //The op parameter is either Edit or Details
    @GetMapping("/assetm/asset/{op}/{id}")
    public String editAsset(@PathVariable Integer id, @PathVariable String op, Model model){
        Asset asset = assetService.findById(id);
        model.addAttribute("asset", asset);
        addModelAttributes(model);
        return "/assetm/asset"+ op; //returns assetEdit or assetDetails
    }

    @RequestMapping(value="/assetm/asset/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id) {
        assetService.deleteById(id);
        return "redirect:/assetm/assets";
    }

}
