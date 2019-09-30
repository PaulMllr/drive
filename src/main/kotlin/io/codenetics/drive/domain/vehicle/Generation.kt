package io.codenetics.drive.domain.vehicle

import java.time.Instant
import javax.persistence.*


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "VEHICLE_MODEL_GENERATION")
class Generation(
        @Id
        @Column(name = "ID")
        var id: String,

        @Column(name = "CREATED_AT")
        var createdAt: Instant,

        @Column(name = "NAME")
        var name: String,

        @ManyToOne(targetEntity = Model::class)
        @JoinColumn(name = "MODEL")
        var model: Model,

        @Column(name = "YEAR_START")
        var yearStart: Int,

        @Column(name = "YEAR_END")
        var yearEnd: Int

)