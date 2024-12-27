package com.Lanka_horizen_hotel_booking_app.Lanka.Horizon.dto;

import com.Lanka_horizen_hotel_booking_app.Lanka.Horizon.entity.Booking;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDTO {

    private long id;
    private String email;
    private String name;
    private String phoneNumber;
    private String role;
    private List<BookingDTO>  bookings= new ArrayList<>();


}
