package com.shipment_tracking.entity;

import com.shipment_tracking.entity.enums.ShipmentStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Builder
public class Shipment
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String origin;

    @NotBlank
    @Column(nullable = false)
    private String destination;

    @NotNull
    @DecimalMin("0.01")
    @Column(nullable = false, precision = 12, scale = 2)
    private BigDecimal weightKg;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    @Builder.Default
    private ShipmentStatus status = ShipmentStatus.POSTED;

    @Column(nullable = false, updatable = false, unique = true)
    private String trackingId;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Size(max = 500, message = "Cargo description cannot exceed 500 characters")
    private String description;
}
