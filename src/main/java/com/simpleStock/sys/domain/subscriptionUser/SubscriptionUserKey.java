package com.simpleStock.sys.domain.subscriptionUser;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubscriptionUserKey implements Serializable {

    @Column(name = "id_user")
    private Long iduser;

    @Column(name = "id_subscription")
    private Long idsubscription;
}
