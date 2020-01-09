package io.codenetics.drive.domain

import java.time.Instant
import javax.persistence.*

/**
 *  Created by Pavel Laktiushkin on 29.09.2019
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "USER_SESSION")
class UserSession(
        @Id
        @Column(name = "ID")
        var id: String,

        @Column(name = "CREATED_AT")
        var createdAt: Instant,

        @ManyToOne(targetEntity = User::class)
        @JoinColumn(name = "USER")
        var user: User

)