package io.codenetics.drive.graphql.mutation

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import graphql.schema.DataFetchingEnvironment
import io.codenetics.drive.exception.AuthenticationException
import io.codenetics.drive.exception.GraphQLRequestError
import io.codenetics.drive.graphql.context.AuthContext
import io.codenetics.drive.graphql.dto.AuthData
import io.codenetics.drive.graphql.dto.SigninPayload
import io.codenetics.drive.graphql.dto.UserDto
import io.codenetics.drive.service.AuthService
import io.codenetics.drive.service.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


/**
 *  Created by Pavel Laktiushkin on 14.03.2019
 */
@Service
class VehicleMutationResolver : GraphQLMutationResolver {


    fun createVehicle(name: String, env: DataFetchingEnvironment): String {
        val user = env.getContext<AuthContext>().user ?: throw GraphQLRequestError("Unauthorized")
        return name
    }
}