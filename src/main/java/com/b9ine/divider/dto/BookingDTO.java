package com.b9ine.divider.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingDTO {

    private Integer id;
    private Integer clientId;
    private Integer bookerId;
    private Integer rsId;
    private LocalDate timeStamp;
    private String bookingStatus;
}
