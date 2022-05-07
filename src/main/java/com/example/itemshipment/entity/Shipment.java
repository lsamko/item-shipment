package com.example.itemshipment.entity;

import com.example.itemshipment.helpers.ShipmentStatus;
import java.time.LocalDateTime;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    private ShipmentStatus status;

    @Basic
    @Column(unique = true, nullable = false, length = 25)
    private String managerId;

    @Basic
    @Column(unique = true, nullable = false, length = 25)
    private String driverId;

    @Basic
    @Column(name = "DATE", nullable = false)
    private LocalDateTime deadlineDate;
}
