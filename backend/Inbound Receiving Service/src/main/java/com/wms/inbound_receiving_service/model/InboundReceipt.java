package com.wms.inbound_receiving_service.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "inbound_receipts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InboundReceipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long receiptId; // Consistent with your DTO 'id' field

    @Column(unique = true, nullable = false)
    private String grnNumber; // Your unique tracking reference

    private LocalDate receiptDate;

    private String status; // e.g., RECEIVED, VERIFIED

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id", nullable = false)
    private Supplier supplier;

    // Helper to link back to the original shipment if needed
    private Long shipmentId;

    @OneToMany(mappedBy = "receipt", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InboundReceiptItem> items = new ArrayList<>();

    // Helper method to add items and maintain bi-directional relationship
    public void addItem(InboundReceiptItem item) {
        items.add(item);
        item.setReceipt(this);
    }
}