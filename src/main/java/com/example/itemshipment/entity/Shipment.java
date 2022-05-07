package com.example.itemshipment.entity;

import com.example.itemshipment.helpers.ShipmentStatus;
import java.time.LocalDateTime;
import java.util.Objects;
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

public class Shipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Transient
    private ShipmentStatus status;

    @Basic
    @Column(nullable = false, length = 25)
    private String managerId;

    @Basic
    @Column(nullable = false, length = 25)
    private String driverId;

    @Basic
    @Column(name = "DATE", nullable = false)
    private LocalDateTime deadlineDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Shipment shipment = (Shipment) o;
        return Objects.equals(id, shipment.id) && status == shipment.status && Objects.equals(managerId,
            shipment.managerId) && Objects.equals(driverId, shipment.driverId) && Objects.equals(
            deadlineDate, shipment.deadlineDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, status, managerId, driverId, deadlineDate);
    }

    public Shipment(Long id, ShipmentStatus status, String managerId, String driverId, LocalDateTime deadlineDate) {
        this.id = id;
        this.status = status;
        this.managerId = managerId;
        this.driverId = driverId;
        this.deadlineDate = deadlineDate;
    }
}
