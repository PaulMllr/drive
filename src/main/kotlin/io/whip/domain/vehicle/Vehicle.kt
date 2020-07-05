package io.whip.domain.vehicle

import io.whip.domain.User
import io.whip.domain.blog.BlogPost
import org.springframework.data.annotation.CreatedDate
import java.time.Instant
import java.util.*
import javax.persistence.*


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "VEHICLE")
class Vehicle(

        @Id
        @Column(name = "ID")
        var id: String = UUID.randomUUID().toString(),

        @Column(name = "CREATED_AT")
        @CreatedDate
        var createdAt: Instant = Instant.now(),

        @Column(name = "NAME")
        var name: String?,

        @Column(name = "DESCRIPTION", length = 2000)
        var description: String?,

        @ManyToOne(targetEntity = User::class)
        @JoinColumn(name = "OWNER")
        var owner: User,

        @Column(name = "YEAR")
        var year: Int,

        @Column(name = "OWNED_SINCE")
        var ownedSince: Int,

        @Column(name = "OWNED_TO")
        var ownedTo: Int?,

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
        var driveTrain: Drivetrain?,

        @Column(name = "HORSEPOWER")
        var horsepower: Int?,

        @OneToMany(mappedBy = "vehicle", targetEntity = BlogPost::class, cascade = [CascadeType.ALL], orphanRemoval = true, fetch = FetchType.LAZY)
        var blogPosts: List<BlogPost> = emptyList()

)
