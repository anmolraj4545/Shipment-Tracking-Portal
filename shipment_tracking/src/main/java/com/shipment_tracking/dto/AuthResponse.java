package com.shipment_tracking.dto;

import com.shipment_tracking.entity.enums.UserRoles;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class AuthResponse
{

    private String token;
    private Long userId;
    private String fullName;
    private String email;
    private UserRoles role;
}
