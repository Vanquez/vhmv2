package com.kindsonthegenius.fleetmsv2.officeequipments.services;

import com.kindsonthegenius.fleetmsv2.officeequipments.models.OfficeEquipmentCategory;
import com.kindsonthegenius.fleetmsv2.officeequipments.repositories.OfficeEquipmentCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeEquipmentCategoryService {
    @Autowired
    private OfficeEquipmentCategoryRepository officeEquipmentCategoryRepository;

    //Method to add equipment category
    public void saveEquipmentCategory(OfficeEquipmentCategory officeEquipmentCategory){

      officeEquipmentCategoryRepository.save(officeEquipmentCategory);
    }

    //Method to find the list of category List
    public List<OfficeEquipmentCategory> findAll(){

        return officeEquipmentCategoryRepository.findAll();
    }

    //Method to find by id
    public OfficeEquipmentCategory findById(int id){

        return officeEquipmentCategoryRepository.findById(id).orElse(null);
    }

    //Method to delete by id
    public void deleteById(int id){

        officeEquipmentCategoryRepository.deleteById(id);
    }
}
