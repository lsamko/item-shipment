package com.example.itemshipment.dto;

import com.example.itemshipment.domain.ShipmentStatus;
import com.sun.istack.NotNull;
import java.time.LocalDateTime;
import javax.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ShipmentRequestDto {
    @NotNull
    private ShipmentStatus status;

    @NotBlank
    private String managerId;

    @NotBlank
    private String driverId;

    @NotNull
    private LocalDateTime deadlineDate;

    public ShipmentRequestDto(ShipmentStatus status, String managerId, String driverId, LocalDateTime deadlineDate) {
        this.status = status;
        this.managerId = managerId;
        this.driverId = driverId;
        this.deadlineDate = deadlineDate;
    }
}
