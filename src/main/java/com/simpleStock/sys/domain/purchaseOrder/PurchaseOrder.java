package com.simpleStock.sys.domain.purchaseOrder;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.simpleStock.sys.domain.inventory.Inventory;
import com.simpleStock.sys.domain.oderProduct.OrderProduct;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "purchase_order")
@Entity(name = "PurchaseOrder")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idorder")
public class PurchaseOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idorder;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime dateOrder;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_inventory")
    private Inventory inventory;

    @OneToMany(mappedBy = "order")
    private List<OrderProduct> orderProducts;
}

