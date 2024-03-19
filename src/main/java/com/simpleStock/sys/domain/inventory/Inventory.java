package com.simpleStock.sys.domain.inventory;

import com.simpleStock.sys.domain.stock.Stock;
import com.simpleStock.sys.domain.store.Store;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "inventory")
@Entity(name = "Inventory")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idinventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idinventory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idstore")
    private Store store;

    @OneToOne(mappedBy = "inventory", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "idstock")
    private Stock stock;
}
