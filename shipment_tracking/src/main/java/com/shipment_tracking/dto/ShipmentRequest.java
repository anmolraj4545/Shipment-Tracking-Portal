package com.shipment_tracking.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ShipmentRequest
{
    @NotBlank(message = "Origin is required")
    @Size(max = 255, message = "Origin cannot exceed 255 characters")
    private String origin;

    @NotBlank(message = "Destination is required")
    @Size(max = 255, message = "Destination cannot exceed 255 characters")
    private String destination;

    @NotNull(message = "Weight is required")
    @DecimalMin(value = "0.01", message = "Weight must be greater than 0")
    @DecimalMax(value = "99999.99", message = "Weight cannot exceed 99,999.99 kg")
    private BigDecimal weightKg;

    @Size(max = 500, message = "Cargo description cannot exceed 500 characters")
    private String description;
}
