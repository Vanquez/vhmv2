package com.kindsonthegenius.fleetmsv2.assetm.services;

import com.kindsonthegenius.fleetmsv2.assetm.models.Asset;
import com.kindsonthegenius.fleetmsv2.assetm.repositories.AssetRepository;
import com.kindsonthegenius.fleetmsv2.fleet.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
