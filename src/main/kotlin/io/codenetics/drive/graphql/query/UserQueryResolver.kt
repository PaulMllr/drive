package io.codenetics.drive.graphql.query

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import graphql.schema.DataFetchingEnvironment
import io.codenetics.drive.exception.GraphQLRequestError
import io.codenetics.drive.graphql.context.AuthContext
import io.codenetics.drive.graphql.dto.UserDto
import org.springframework.stereotype.Service

/**
 *  Created by Pavel Laktiushkin on 14.03.2019
 */
@Service
class UserQueryResolver : GraphQLQueryResolver {

    fun getUser(env: DataFetchingEnvironment): UserDto {
        val user = env.getContext<AuthContext>().user ?: throw GraphQLRequestError("Unauthorized")
        return UserDto(user.id, user.name, user.email)
    }

}