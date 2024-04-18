package com.kindsonthegenius.fleetmsv2.officeequipments.services;

import com.kindsonthegenius.fleetmsv2.officeequipments.models.OfficeEquipmentStatus;
import com.kindsonthegenius.fleetmsv2.officeequipments.repositories.OfficeEquipmentRepository;
import com.kindsonthegenius.fleetmsv2.officeequipments.repositories.OfficeEquipmentStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeEquipmentStatusService {
    @Autowired
    private OfficeEquipmentStatusRepository officeEquipmentStatusRepository;

    //Method to add status
    public void save(OfficeEquipmentStatus officeEquipmentStatus) {

        officeEquipmentStatusRepository.save(officeEquipmentStatus);

    }

    //Method to find all statuses
    public List<OfficeEquipmentStatus> findAll(){

        return officeEquipmentStatusRepository.findAll();
    }

    //Method to find by Id
    public OfficeEquipmentStatus findById(int id){

       return officeEquipmentStatusRepository.findById(id).orElse(null);


    }

}
