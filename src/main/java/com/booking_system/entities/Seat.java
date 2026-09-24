package com.booking_system.entities;

import com.booking_system.entities.simple_entity.SeatId;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Table(name = "seats")
@Entity
@IdClass(SeatId.class)
public class Seat {

    @Id
    @Column(name = "seats_no", length = 4, nullable = false)
    @ToString.Include
    @EqualsAndHashCode.Include
    private String seatsNo;

    @Id
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "aircraft_id", nullable = false)
    @EqualsAndHashCode.Include
    private Aircraft aircraft;
}
