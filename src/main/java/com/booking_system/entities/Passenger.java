package com.booking_system.entities;

import com.booking_system.converter.BirthdayConverter;
import com.booking_system.entities.simple_entity.Birthday;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "passenger")
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class Passenger {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @ToString.Include
    private Long id;

    @ToString.Include
    @Column(name = "first_name", nullable = false, length = 128)
    private String firstName;

    @ToString.Include
    @Column(name = "middle_name", length = 128)
    private String middleName;

    @ToString.Include
    @Column(name = "last_name", nullable = false, length = 128)
    private String lastName;

    @ToString.Include
    @Convert(converter = BirthdayConverter.class)
    @Column(name = "birthday_date", nullable = false)
    private Birthday birthday;

    @ToString.Include
    @Column(name = "mail", nullable = false, unique = true, length = 128)
    private String passengerMail;

    @ToString.Include
    @Column(name = "loyalty_card", nullable = false)
    private boolean loyaltyCard;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "passenger_discount",
            joinColumns = @JoinColumn(name = "passenger_id"),
            inverseJoinColumns = @JoinColumn(name = "discount_id")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Discount> passengerDiscounts = new HashSet<>();

    @OneToMany(mappedBy = "passenger", fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    List<Ticket> tickets = new ArrayList<>();
}
