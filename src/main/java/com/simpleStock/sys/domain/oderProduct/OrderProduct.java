package com.simpleStock.sys.domain.oderProduct;

import com.simpleStock.sys.domain.product.Product;
import com.simpleStock.sys.domain.purchaseOrder.PurchaseOrder;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "order_product")
@Entity(name = "OrderProduct")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class OrderProduct {

    @EmbeddedId
    private OrderProductKey id;

    @ManyToOne
    @MapsId("idorder")
    @JoinColumn(name = "idorder")
    private PurchaseOrder order;

    @ManyToOne
    @MapsId("idproduct")
    @JoinColumn(name = "idproduct")
    private Product product;

    private float price, quantity;
}
