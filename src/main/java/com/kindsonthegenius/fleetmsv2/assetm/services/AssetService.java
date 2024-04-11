package com.kindsonthegenius.fleetmsv2.assetm.services;

import com.kindsonthegenius.fleetmsv2.assetm.models.Asset;
import com.kindsonthegenius.fleetmsv2.assetm.repositories.AssetRepository;
import com.kindsonthegenius.fleetmsv2.fleet.models.Vehicle;
import com.kindsonthegenius.fleetmsv2.hr.models.Employee;
import com.kindsonthegenius.fleetmsv2.hr.repositories.EmployeeRepository;
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

    private EmployeeRepository employeeRepository;

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

//    public void assignUserRole(Integer userId, Integer roleId) {
//        User user = userRepository.findById(userId).orElse(null);
//        Role role = roleRepository.findById(roleId).orElse(null);
//        Set<Role> userRoles = user.getRoles();
//        userRoles.add(role);
//        user.setRoles(userRoles);
//        userRepository.save(user);
//    }


    // Method to assign asset
    public void assignAsset(Integer employeeId, Integer assetId){
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        Asset asset = assetRepository.findById(assetId).orElse(null);
        Set<Asset> employeeAssets = employee.getAssets();
        employeeAssets.add(asset);
        employee.setAssets(employeeAssets);
        employeeRepository.save(employee);
    }



//    public void unassignUserRole(Integer userId, Integer roleId) {
//        User user = userRepository.findById(userId).orElse(null);
//        user.getRoles().removeIf(x -> x.getId() == roleId);
//        userRepository.save(user);
//    }


    // Method to unassign an asset
    public void unassignAsset(Integer employeeId, Integer assetId){
        Employee employee = employeeRepository.findById(employeeId).orElse(null);
        employee.getAssets().removeIf( x -> x.getAsset_id() == assetId);
         employeeRepository.save(employee);
    }

}
