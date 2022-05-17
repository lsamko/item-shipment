package com.example.itemshipment.dto;

import com.example.itemshipment.helpers.ShipmentStatus;
import com.sun.istack.NotNull;
import java.time.LocalDateTime;
import javax.persistence.Basic;
import javax.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ShipmentRequestDto {
    @NotNull
    private ShipmentStatus status;

    @NotNull
    private String managerId;

    @NotNull
    private String driverId;

    @NotNull
    private LocalDateTime deadlineDate;
}
