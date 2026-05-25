package com.shipment_tracking.entity.enums;

public enum ShipmentStatus
{
    POSTED,           // Load posted by shipper, open for bids
    AWAITING_PICKUP,  // Bid accepted, locked to carrier
    IN_TRANSIT,
    DELIVERED
}
