package com.Lanka_horizen_hotel_booking_app.Lanka.Horizon.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data

public class LoginRequest {

    @NotBlank(message = "Email is Required")
    private String email;
    @NotBlank(message = "Email is Required")
    private String password;

}
