package com.simpleStock.sys.domain.product;

import com.simpleStock.sys.domain.oderProduct.OrderProduct;
import com.simpleStock.sys.domain.stock.Stock;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "product")
@Entity(name = "Product")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idproduct")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idproduct;

    private String name, code, description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idstock")
    private Stock stock;

    @OneToMany(mappedBy = "product")
    private List<OrderProduct> orderProducts;
}
