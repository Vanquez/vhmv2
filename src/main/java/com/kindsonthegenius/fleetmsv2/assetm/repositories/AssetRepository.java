package com.kindsonthegenius.fleetmsv2.assetm.repositories;

import com.kindsonthegenius.fleetmsv2.assetm.models.Asset;
import com.kindsonthegenius.fleetmsv2.security.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Integer> {


//    @Query(
//            value = "SELECT * FROM role WHERE id NOT IN (SELECT role_id FROM user_role WHERE user_id = ?1)",
//            nativeQuery = true
//    )
//    List<Role> getUserNotRoles(Integer userId);

    @Query(
            value = "SELECT * FROM asset WHERE asset_id NOT IN (SELECT asset_id FROM employee_asset WHERE id= ?1)",
            nativeQuery = true
    )

   List<Asset> getNotAssets(Integer employeeId);


}
