package com.simpleStock.sys.domain.user;

import com.simpleStock.sys.domain.subscriptionUser.SubcriptionUser;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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

    @OneToMany(mappedBy = "user")
    private List<SubcriptionUser> subcriptionUsers;
}
