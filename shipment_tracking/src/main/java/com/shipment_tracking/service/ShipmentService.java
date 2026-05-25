package com.shipment_tracking.service;


import com.shipment_tracking.dto.ShipmentRequest;
import com.shipment_tracking.dto.ShipmentResponse;
import com.shipment_tracking.entity.Shipment;
import com.shipment_tracking.entity.enums.ShipmentStatus;
import com.shipment_tracking.repository.ShipmentRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
public class ShipmentService
{
    private final ShipmentRepository shipmentRepository;

    public ShipmentService(ShipmentRepository shipmentRepository) {
        this.shipmentRepository = shipmentRepository;
    }


    public ShipmentResponse create(@Valid ShipmentRequest request)
    {
        Shipment shipment=Shipment.builder()
                .origin(request.getOrigin())
                .destination(request.getDestination())
                .weightKg(request.getWeightKg())
                .createdAt(LocalDateTime.now())
                .trackingId("TRK-" + System.currentTimeMillis())
                .description(request.getDescription())
                .build();
        shipment = shipmentRepository.save(shipment);
        return toResponse(shipment);
    }

    private ShipmentResponse toResponse(Shipment s)
    {
        return ShipmentResponse.builder()
                .id(s.getId())
                .origin(s.getOrigin())
                .destination(s.getDestination())
                .weightKg(s.getWeightKg())
                .status(s.getStatus())
                .trackingCode(s.getTrackingId())
                .description(s.getDescription())
                .build();
    }

}
