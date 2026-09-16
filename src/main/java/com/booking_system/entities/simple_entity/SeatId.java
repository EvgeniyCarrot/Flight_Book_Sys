package com.booking_system.entities.simple_entity;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class SeatId implements Serializable {
    private Integer aircraft;
    private String seatsNo;
}
