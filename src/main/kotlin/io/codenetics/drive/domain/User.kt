package io.codenetics.drive.domain


import java.time.Instant
import javax.persistence.*

/**
 *  Created by Pavel Laktiushkin on 29.09.2019
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "USER", indexes = [Index(name = "EMAIL_UIX", unique = true, columnList = "EMAIL")])
class User(
        @Id
        @Column(name = "ID")
        var id: String,

        @Column(name = "CREATED_AT")
        var createdAt: Instant,

        @Column(name = "EMAIL")
        var email: String,

        @Column(name = "PASSWORD")
        var password: String,

        @Column(name = "FULL_NAME")
        var fullName: String


) {
    constructor() : this("", Instant.now(), "", "", "")


}