package com.kindsonthegenius.fleetmsv2.assetm.services;

import com.kindsonthegenius.fleetmsv2.assetm.models.Asset;
import com.kindsonthegenius.fleetmsv2.assetm.repositories.AssetRepository;
import com.kindsonthegenius.fleetmsv2.fleet.models.Vehicle;
import com.kindsonthegenius.fleetmsv2.hr.models.Employee;
import com.kindsonthegenius.fleetmsv2.security.models.Role;
import com.kindsonthegenius.fleetmsv2.security.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class AssetService {
    @Autowired
    private AssetRepository assetRepository;

    //Method to return a list of assets
    public List<Asset> findAll(){

        return assetRepository.findAll();
    }

    //Save Asset
    public void save(Asset asset){

        assetRepository.save(asset);}

    //Get Vehicle By Id
    public Asset findById(int id) {

        return assetRepository.findById(id).orElse(null);
    }

    // delect by id

    public void deleteById(int id){

        assetRepository.deleteById(id);
    }

    public Set<Role> getUserRoles(User user) {
        return user.getRoles();
    }

    public Set<Asset> getAssets(Employee employee){ return employee.getAssets();}

//    public List<Role> getNotAssets(User user) {
//        return roleRepository.getUserNotRoles(user.getId());
//    }

    public List<Asset> getNotAssets(Employee employee) {
        return assetRepository.getNotAssets(employee.getId());
    }
}
