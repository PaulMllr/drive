package io.whip.domain.vehicle

import java.time.Instant
import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "VEHICLE_MANUFACTURER")
class Manufacturer(
        @Id
        @Column(name = "ID")
        var id: String,

        @Column(name = "CREATED_AT")
        var createdAt: Instant,

        @Column(name = "NAME")
        var name: String


)
