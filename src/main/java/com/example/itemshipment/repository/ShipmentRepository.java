package com.example.itemshipment.repository;

import com.example.itemshipment.entity.Shipment;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment, Long> {

    Optional<Shipment> findShipmentById(String uuid);
}
