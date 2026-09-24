package com.booking_system.entities;

import com.booking_system.enums.FlightStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(onlyExplicitlyIncluded = true)
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "flights")
@OptimisticLocking(type = OptimisticLockType.VERSION)
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    @EqualsAndHashCode.Include
    private Long id;

    @Column(name = "flight_no", length = 32, nullable = false)
    @ToString.Include
    private String flightNo;

    @Column(name = "departure_date", nullable = false)
    @ToString.Include
    private LocalDateTime departureDate;

    @Column(name = "arrival_date", nullable = false)
    @ToString.Include
    private LocalDateTime arrivalDate;

    @Column(name = "status", length = 32, nullable = false)
    @ToString.Include
    @Enumerated(EnumType.STRING)
    private FlightStatus status;

    @Version
    @Column(name = "version", nullable = false)
    @ToString.Include
    @EqualsAndHashCode.Include
    private Long version;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "aircraft_id", nullable = false)
    private Aircraft aircraft;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "departure_airport_code", nullable = false)
    private Airport departureAirport;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "arrival_airport_code", nullable = false)
    private Airport arrivalAirport;
}
