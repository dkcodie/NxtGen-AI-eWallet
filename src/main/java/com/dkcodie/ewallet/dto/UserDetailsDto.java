package com.dkcodie.ewallet.dto;

import lombok.Data;

@Data
public class UserDetailsDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Double walletBalance; // Add wallet balance field
}
