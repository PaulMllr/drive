package io.whip.graphql.entityresolver

import com.coxautodev.graphql.tools.GraphQLResolver
import io.whip.graphql.dto.SigninPayload
import io.whip.graphql.dto.UserDto


/**
 *  Created by Pavel Laktiushkin on 28.09.2019
 */
class SigninResolver : GraphQLResolver<SigninPayload> {
    fun user(payload: SigninPayload): UserDto {
        return payload.user
    }
}
