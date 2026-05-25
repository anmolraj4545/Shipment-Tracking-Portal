package com.shipment_tracking.dto;

import com.shipment_tracking.entity.enums.ShipmentStatus;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ShipmentResponse
{
    private Long id;
    private String trackingCode;
    private String origin;
    private String destination;
    private BigDecimal weightKg;
    private String description;
    private ShipmentStatus status;
}
