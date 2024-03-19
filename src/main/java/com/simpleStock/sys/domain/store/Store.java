package com.simpleStock.sys.domain.store;

import com.simpleStock.sys.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

@Table(name = "store")
@Entity(name = "Store")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idstore")
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idstore;
    private String name, nit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner")
    private User user;
}
