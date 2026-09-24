package com.booking_system.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Table(name = "aircraft")
@Entity
public class Aircraft {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @ToString.Include
    private Integer id;

    @Column(nullable = false, unique = true, length = 64)
    @ToString.Include
    private String model;

    @Column(name = "number_of_seats", nullable = false)
    @ToString.Include
    private Short numberOfSeats;

    @OneToMany(mappedBy = "aircraft", fetch = FetchType.LAZY)
    @Builder.Default
    Set<Seat> seats = new HashSet<>();
}
