package io.whip.graphql.dto

import java.time.Instant

/**
 *  Created by Pavel Laktiushkin on 14.10.2019
 */
data class BlogPostDto(val user: UserDto,val createdAt: Instant,val message: String)
