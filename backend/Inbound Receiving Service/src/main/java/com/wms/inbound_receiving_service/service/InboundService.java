package com.wms.inbound_receiving_service.service;

import com.wms.inbound_receiving_service.dto.*;
import java.util.List;

public interface InboundService {
    InboundResponseDTO receiveShipment(InboundRequestDTO request);
    InboundResponseDTO getShipmentById(Long id);
    List<InboundResponseDTO> getAllShipments();
    InboundResponseDTO updateShipmentStatus(Long id, String status);
    void deleteShipment(Long id);

    // Add these two to fix the Controller errors
    List<InboundReceiptDTO> getAllReceipts();
    List<InboundReceiptItemDTO> getAllReceiptItems();
}