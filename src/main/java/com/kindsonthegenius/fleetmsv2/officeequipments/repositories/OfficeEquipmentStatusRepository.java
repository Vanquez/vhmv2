package com.kindsonthegenius.fleetmsv2.officeequipments.repositories;

import com.kindsonthegenius.fleetmsv2.officeequipments.models.OfficeEquipmentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeEquipmentStatusRepository extends JpaRepository<OfficeEquipmentStatus, Integer> {
}
