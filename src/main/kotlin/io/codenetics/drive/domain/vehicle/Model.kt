package io.codenetics.drive.domain.vehicle

import java.time.Instant
import javax.persistence.*


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "VEHICLE_MODEL")
class Model(
        @Id
        @Column(name = "ID")
        var id: String,

        @Column(name = "CREATED_AT")
        var createdAt: Instant,

        @Column(name = "NAME")
        var name: String,

        @ManyToOne(targetEntity = Manufacturer::class)
        @JoinColumn(name = "MANUFACTURER")
        var manufacturer: Manufacturer,

        @Column(name = "MARKET")
        @Enumerated(EnumType.STRING)
        var market: Market
)