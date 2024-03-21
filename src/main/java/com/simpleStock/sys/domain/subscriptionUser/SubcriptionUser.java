package com.simpleStock.sys.domain.subscriptionUser;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.simpleStock.sys.domain.subscription.Subscription;
import com.simpleStock.sys.domain.user.User;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Table(name = "subcription_user")
@Entity(name = "SubcriptionUser")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class SubcriptionUser {

    @EmbeddedId
    private SubscriptionUserKey id;

    @ManyToOne
    @MapsId("iduser")
    @JoinColumn(name = "id_user")
    private User user;

    @ManyToOne
    @MapsId("idsubscription")
    @JoinColumn(name = "id_subscription")
    private Subscription subscription;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime startDate, finishDate;
}