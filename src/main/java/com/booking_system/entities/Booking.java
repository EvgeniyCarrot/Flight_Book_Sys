package com.booking_system.entities;

import com.booking_system.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Table(name = "booking")
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ToString.Include
    @EqualsAndHashCode.Include
    private Long id;

    @ToString.Include
    @Column(name = "booking_status", nullable = false, length = 64)
    @Enumerated(EnumType.STRING)
    private BookingStatus bookingStatus;

    @ToString.Include
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;
}
