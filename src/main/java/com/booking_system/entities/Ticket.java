package com.booking_system.entities;

import com.booking_system.enums.TicketStatus;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Table(name = "tickets")
@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @ToString.Include
    private Long id;

    @Column(name = "price", nullable = false)
    @ToString.Include
    private BigDecimal price;

    @Column(name = "tickets_no", nullable = false, unique = true, length = 64)
    @ToString.Include
    private String ticketsNo;

    @Column(name = "seat_no", nullable = false, length = 4)
    @ToString.Include
    private String seatNo;

    @Column(name = "status", nullable = false, length = 32)
    @ToString.Include
    @Enumerated(EnumType.STRING)
    private TicketStatus status;

    @Column(name = "locked_at")
    @ToString.Include
    private LocalDateTime lockedAt;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "flight_id", nullable = false)
    private Flight flight;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "passenger_id", nullable = false)
    private Passenger passenger;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "booking_id", nullable = false)
    private Booking booking;
}
