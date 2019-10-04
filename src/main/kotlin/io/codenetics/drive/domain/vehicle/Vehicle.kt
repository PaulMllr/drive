package io.codenetics.drive.domain.vehicle

import io.codenetics.drive.domain.User
import java.time.Instant
import javax.persistence.*


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "VEHICLE")
class Vehicle(

        @Id
        @Column(name = "ID")
        var id: String,

        @Column(name = "CREATED_AT")
        var createdAt: Instant,

        @Column(name = "NAME")
        var name: String,

        @Column(name = "DESCRIPTION", length = 2000)
        var description: String?,

        @ManyToOne(targetEntity = User::class)
        @JoinColumn(name = "OWNER")
        var owner: User,

        @Column(name = "YEAR")
        var year: Int,

        @Column(name = "OWNED_SINCE")
        var ownedSince: Instant,

        @Column(name = "OWNED_TO")
        var ownedTo: Instant?,

        @ManyToOne(targetEntity = Model::class)
        @JoinColumn(name = "MODEL")
        var model: Model,

        @ManyToOne(targetEntity = Generation::class)
        @JoinColumn(name = "GENERATION")
        var generation: Generation,

        @Column(name = "DISPLACEMENT")
        var displacement: Float?,

        @Column(name = "ENGINE_TYPE")
        @Enumerated(EnumType.STRING)
        var engineType: EngineType?,

        @Column(name = "TRANSMISSION")
        @Enumerated(EnumType.STRING)
        var transmission: Transmission?,

        @Column(name = "DRIVETRAIN")
        @Enumerated(EnumType.STRING)
        var driveTrain: DriveTrain?,

        @Column(name = "HORSEPOWER")
        var horsepower: Int?

)