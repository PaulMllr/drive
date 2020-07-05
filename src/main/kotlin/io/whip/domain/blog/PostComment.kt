package io.whip.domain.blog

import io.whip.domain.User
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
@Table(name = "POST_COMMENT")
class PostComment(

        @Id
        @Column(name = "ID")
        var id: String = UUID.randomUUID().toString(),

        @Column(name = "CREATED_AT")
        @CreatedDate
        var createdAt: Instant = Instant.now(),

        @Column(name = "MESSAGE", length = 4096)
        var message: String,

        @ManyToOne(targetEntity = User::class)
        @JoinColumn(name = "WRITTEN_BY")
        var writtenBy: User,

        @ManyToOne(targetEntity = BlogPost::class)
        @JoinColumn(name = "BLOG_POST")
        var blogPost: BlogPost,

        @ManyToOne(targetEntity = PostComment::class)
        @JoinColumn(name = "PARENT")
        var parent: PostComment?


)
