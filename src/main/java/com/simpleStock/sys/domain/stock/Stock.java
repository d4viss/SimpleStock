package com.simpleStock.sys.domain.stock;

import com.simpleStock.sys.domain.inventory.Inventory;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "stock")
@Entity(name = "Stock")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idstock")
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idstock;
    private float price;
    private float quantity;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idinventory")
    private Inventory inventory;
}
