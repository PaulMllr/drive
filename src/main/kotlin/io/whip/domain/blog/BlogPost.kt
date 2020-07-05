package io.whip.domain.blog

import io.whip.domain.vehicle.Model
import io.whip.domain.vehicle.Vehicle
import org.springframework.data.annotation.CreatedDate
import java.time.Instant
import java.util.*
import javax.persistence.*

/**
 *  Created by Pavel Laktiushkin on 13.10.2019
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "BLOG_POST")
class BlogPost(

        @Id
        @Column(name = "ID")
        var id: String = UUID.randomUUID().toString(),

        @Column(name = "CREATED_AT")
        @CreatedDate
        var createdAt: Instant = Instant.now(),

        @Column(name = "MESSAGE", length = 4096)
        var message: String,

        @ManyToOne(targetEntity = Vehicle::class, optional = true, fetch = FetchType.LAZY)
        @JoinColumn(name = "VEHICLE")
        var vehicle: Vehicle?


)
