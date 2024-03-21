package com.simpleStock.sys.domain.subscription;

import com.simpleStock.sys.domain.subscriptionUser.SubcriptionUser;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Table(name = "subscription")
@Entity(name = "Subscription")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "idsubscription")
public class Subscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idsubscription;

    @OneToMany(mappedBy = "subscription")
    private List<SubcriptionUser> subcriptionUsers;
}
