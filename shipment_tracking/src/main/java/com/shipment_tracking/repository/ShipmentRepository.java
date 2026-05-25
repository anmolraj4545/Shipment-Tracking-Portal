package com.shipment_tracking.repository;

import com.shipment_tracking.entity.Shipment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment,Long>
{

}
