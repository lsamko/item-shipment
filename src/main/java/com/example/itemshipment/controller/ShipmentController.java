package com.example.itemshipment.controller;

import com.example.itemshipment.dto.ShipmentRequestDto;
import com.example.itemshipment.dto.ShipmentResponseDto;
import com.example.itemshipment.service.ShipmentService;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shipments")
public class ShipmentController {

    private final ShipmentService shipmentService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ShipmentResponseDto createShipment(@Valid @RequestBody ShipmentRequestDto shipmentRequestDto) {
        return shipmentService.createShipment(shipmentRequestDto);
    }
}
