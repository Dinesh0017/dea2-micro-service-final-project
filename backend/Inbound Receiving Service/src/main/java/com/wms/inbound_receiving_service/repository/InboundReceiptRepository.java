package com.wms.inbound_receiving_service.repository;

import com.wms.inbound_receiving_service.model.InboundReceipt;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InboundReceiptRepository extends JpaRepository<InboundReceipt, Long> {

    // Useful for your Dashboard "Latest Arrivals" view
    List<InboundReceipt> findAllByOrderByReceiptDateDesc();

    // To prevent duplicate entries when creating new receipts
    Optional<InboundReceipt> findByGrnNumber(String grnNumber);

    // To filter receipts by status (e.g., "PENDING", "VERIFIED")
    List<InboundReceipt> findByStatus(String status);
}