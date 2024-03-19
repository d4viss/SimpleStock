package com.simpleStock.sys.domain.user;

import jakarta.persistence.*;
import lombok.*;

@Table(name = "user")
@Entity(name = "Usuario")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "iduser")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long iduser;
    private String name, lastname, userName, password;
}
