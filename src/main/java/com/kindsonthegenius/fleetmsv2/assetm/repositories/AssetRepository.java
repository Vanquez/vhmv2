package com.kindsonthegenius.fleetmsv2.assetm.repositories;

import com.kindsonthegenius.fleetmsv2.assetm.models.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Integer> {



}
