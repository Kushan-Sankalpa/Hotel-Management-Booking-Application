package com.Lanka_horizen_hotel_booking_app.Lanka.Horizon.entity;

import jakarta.persistence.*;
import jakarta.persistence.criteria.Root;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;


import java.time.LocalDate;


@Data
@Entity
@Table (name = "bookings")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull (message = "Check in date is required")
    private LocalDate checkInDate;
    @Future(message = "Check out date is required")
    private LocalDate checkOutDate;


    @Min(value = 1, message = "Number of Adults must not be less than 1 ")
    private int numOfAdults;

    @Min(value = 0, message = "Number of Children must not be less than 0 ")
    private int numOfChildren;

    private int totalNumberOfGuest;

    private String bookingConfirmationCode;

    @ManyToOne(fetch = FetchType.EAGER )
    @JoinColumn(name = "user_id" )
    private User user;



    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "room_id" )
    private Room room;

    public void calculateTotalNumberOfGuest() {
        this.totalNumberOfGuest = this.numOfAdults + this.numOfChildren;
    }


    public void setNumOfAdults(@Min(value = 1, message = "Number of Adults must not be less than 1 ") int numOfAdults) {
        this.numOfAdults = numOfAdults;
        calculateTotalNumberOfGuest();
    }

    public void setNumOfChildren(@Min(value = 0, message = "Number of Children must not be less than 0 ") int numOfChildren) {
        this.numOfChildren = numOfChildren;
        calculateTotalNumberOfGuest();
    }

    @Override
    public String toString() {
        return "Booking{" +
                "id=" + id +
                ", checkInDate=" + checkInDate +
                ", checkOutDate=" + checkOutDate +
                ", numOfAdults=" + numOfAdults +
                ", numOfChildren=" + numOfChildren +
                ", totalNumberOfGuest=" + totalNumberOfGuest +
                ", bookingConfirmationCode='" + bookingConfirmationCode + '\'' +
                ", user=" + user +
                ", room=" + room +
                '}';
    }
}
