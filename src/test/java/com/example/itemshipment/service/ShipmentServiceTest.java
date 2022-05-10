package com.example.itemshipment.service;

import static com.example.itemshipment.helpers.ShipmentStatus.READY;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.example.itemshipment.dto.ShipmentRequestDto;
import com.example.itemshipment.entity.Shipment;
import com.example.itemshipment.exception.ShipmentNotFoundException;
import com.example.itemshipment.helpers.ShipmentStatus;
import com.example.itemshipment.mapper.ShipmentMapper;
import com.example.itemshipment.mapper.ShipmentMapperImpl;
import com.example.itemshipment.repository.ShipmentRepository;
import com.example.itemshipment.service.implementation.ShipmentServiceImpl;
import java.time.LocalDateTime;
import java.util.Optional;
import liquibase.repackaged.org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

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
    ArgumentCaptor<Shipment> shipmentArgumentCaptor;
    @Captor
    ArgumentCaptor<String> idCaptor;

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
    public void testCreateShipmentOk() {
        shipmentServiceImpl.createShipment(shipmentRequestDto);
        verify(shipmentRepository, times(1)).save(shipmentArgumentCaptor.capture());
        Shipment captureShipment = shipmentArgumentCaptor.getValue();
        assertNull(captureShipment.getId());
        assertEquals(captureShipment.getStatus(), status);
        assertEquals(captureShipment.getManagerId(), shipmentRequestDto.getManagerId());
        assertEquals(captureShipment.getDriverId(), driverId);
        assertEquals(captureShipment.getDeadlineDate(), deadlineDate);
    }

    @Test
    public void testFindShipmentById() {
        Shipment shipment = new Shipment(1L, READY, "2", "4", deadlineDate);
        when(shipmentRepository.findShipmentById(idCaptor.capture())).thenReturn(Optional.of(shipment));
        String uuid = "1";
        shipmentServiceImpl.findById(uuid);
        String value = idCaptor.getValue();
        assertThat(value, is(equalTo(uuid)));
    }

    @Test
    public void testFindShipmentByIdNotFound() {
        when(shipmentRepository.findShipmentById(Mockito.anyString()))
            .thenReturn(Optional.empty());
        assertThrows(ShipmentNotFoundException.class, () -> shipmentServiceImpl.findById(RandomStringUtils.random(5)));
    }
}
