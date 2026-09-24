package com.booking_system.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Table(name = "airport")
@Entity
public class Airport {

    @Id
    @Column(name = "airport_code", length = 3, nullable = false)
    @EqualsAndHashCode.Include
    @ToString.Include
    private String airportCode;

    @Column(name = "airport_country", nullable = false, length = 64)
    @ToString.Include
    private String airportCountry;

    @Column(name = "airport_city", nullable = false, length = 128)
    @ToString.Include
    private String airportCity;

    @Column(nullable = false, length = 32)
    @ToString.Include
    private String timezone;

    @OneToMany(mappedBy = "departureAirport", fetch = FetchType.LAZY)
    @Builder.Default
    List<Flight> departureFlights = new ArrayList<>();

    @OneToMany(mappedBy = "arrivalAirport", fetch = FetchType.LAZY)
    @Builder.Default
    List<Flight> arrivalFlights = new ArrayList<>();
}
