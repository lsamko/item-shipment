package com.example.itemshipment.service;

import com.example.itemshipment.dto.ShipmentRequestDto;
import com.example.itemshipment.dto.ShipmentResponseDto;

public interface ShipmentService {

    ShipmentResponseDto createShipment(ShipmentRequestDto shipmentRequestDto);

    ShipmentResponseDto findById(String uuid);
}
