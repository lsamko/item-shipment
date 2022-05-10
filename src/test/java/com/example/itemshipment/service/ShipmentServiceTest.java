package com.example.itemshipment.service;

import com.example.itemshipment.dto.ShipmentRequestDto;
import com.example.itemshipment.entity.Shipment;
import com.example.itemshipment.helpers.ShipmentStatus;
import com.example.itemshipment.mapper.ShipmentMapper;
import com.example.itemshipment.mapper.ShipmentMapperImpl;
import com.example.itemshipment.repository.ShipmentRepository;
import com.example.itemshipment.service.implementation.ShipmentServiceImpl;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class ShipmentServiceTest {

    public static final String managerId = "197";
    public static final String driverId = "12";
    public static final ShipmentStatus status = ShipmentStatus.NOT_READY;
    public static final LocalDateTime deadlineDate = LocalDateTime.of(2022, 5, 23, 12, 0);


    @Mock
    private ShipmentRepository shipmentRepository;
    private ShipmentRequestDto shipmentRequestDto;
    private final ShipmentMapper shipmentMapper = new ShipmentMapperImpl();
    private ShipmentServiceImpl shipmentServiceImpl;
    @Captor
    ArgumentCaptor<Shipment>shipmentArgumentCaptor;

    @BeforeEach
    public void setUp() {
        shipmentServiceImpl = new ShipmentServiceImpl(shipmentMapper, shipmentRepository);
        shipmentRequestDto = new ShipmentRequestDto();
        shipmentRequestDto.setStatus(status);
        shipmentRequestDto.setManagerId(managerId);
        shipmentRequestDto.setDriverId(driverId);
        shipmentRequestDto.setDeadlineDate(deadlineDate);
    }

    @Test
    public void testCreateShipmentOk(){
        shipmentServiceImpl.createShipment(shipmentRequestDto);
        verify(shipmentRepository, times(1)).save(shipmentArgumentCaptor.capture());
        Shipment captureShipment = shipmentArgumentCaptor.getValue();
        assertNull(captureShipment.getId());
        assertEquals(captureShipment.getStatus(), status);
        //TODO check why id is auto generated
      // assertEquals(captureShipment.getManagerId(), shipmentRequestDto.getManagerId());
        assertEquals(captureShipment.getDriverId(), driverId);
        assertEquals(captureShipment.getDeadlineDate(), deadlineDate);
    }
}
