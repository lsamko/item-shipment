package com.example.itemshipment.dto;

import com.example.itemshipment.helpers.ShipmentStatus;
import java.time.LocalDateTime;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ShipmentResponseDto {

    private ShipmentStatus status;
    private String managerId;
    private String driverId;
    private LocalDateTime deadlineDate;
}
