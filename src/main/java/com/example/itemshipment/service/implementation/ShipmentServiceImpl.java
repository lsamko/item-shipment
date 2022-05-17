package com.example.itemshipment.service.implementation;

import com.example.itemshipment.dto.ShipmentRequestDto;
import com.example.itemshipment.dto.ShipmentResponseDto;
import com.example.itemshipment.entity.Shipment;
import com.example.itemshipment.exception.ShipmentNotFoundException;
import com.example.itemshipment.mapper.ShipmentMapper;
import com.example.itemshipment.repository.ShipmentRepository;
import com.example.itemshipment.service.ShipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShipmentServiceImpl implements ShipmentService {

    private final ShipmentMapper shipmentMapper;
    private final ShipmentRepository shipmentRepository;

    @Override
    public ShipmentResponseDto createShipment(ShipmentRequestDto shipmentRequestDto) {
        Shipment shipment = shipmentMapper.fromRequestDtoToEntity(shipmentRequestDto);
        Shipment shipmentToSave = shipmentRepository.save(shipment);
        return shipmentMapper.fromEntityToResponseDto(shipmentToSave);
    }

    @Override
    public ShipmentResponseDto findById(String uuid) {
        return shipmentRepository.findShipmentById(uuid).
            map(shipmentMapper::fromEntityToResponseDto)
            .orElseThrow(() -> new ShipmentNotFoundException("Could not find shipment: " + uuid));
    }
}
