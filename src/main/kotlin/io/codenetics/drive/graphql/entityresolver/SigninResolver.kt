package io.codenetics.drive.graphql.entityresolver

import com.coxautodev.graphql.tools.GraphQLResolver
import io.codenetics.drive.graphql.dto.SigninPayload
import io.codenetics.drive.graphql.dto.User


/**
 *  Created by Pavel Laktiushkin on 28.09.2019
 */
class SigninResolver : GraphQLResolver<SigninPayload> {
    fun user(payload: SigninPayload): User {
        return payload.user
    }
}