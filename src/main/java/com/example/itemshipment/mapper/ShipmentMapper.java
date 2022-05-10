package com.example.itemshipment.mapper;

import com.example.itemshipment.dto.ShipmentRequestDto;
import com.example.itemshipment.dto.ShipmentResponseDto;
import com.example.itemshipment.entity.Shipment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ShipmentMapper {

    @Mapping(target = "managerId")
    Shipment fromRequestDtoToEntity(ShipmentRequestDto shipmentRequestDto);

    ShipmentResponseDto fromEntityToResponseDto(Shipment shipment);
}
