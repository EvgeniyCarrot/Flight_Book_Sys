package com.booking_system.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "discount")
public class Discount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @ToString.Include
    private Integer id;

    @Column(name = "discount_status", nullable = false, unique = true, length = 128)
    @ToString.Include
    private String discountStatus;

    @Column(name = "rate_percent", nullable = false)
    @ToString.Include
    private BigDecimal ratePercent;

    @ManyToMany(mappedBy = "passengerDiscounts", fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Passenger> passengers = new HashSet<>();
}
