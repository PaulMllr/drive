package io.codenetics.drive.graphql.mutation

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import io.codenetics.drive.exception.AuthenticationException
import io.codenetics.drive.exception.GraphQLRequestError
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
class UserMutationResolver : GraphQLMutationResolver {

    @Autowired
    private lateinit var userService: UserService

    @Autowired
    private lateinit var authService: AuthService

    fun registerUser(name: String, auth: AuthData): UserDto {
        if (userService.existsUserByEmail(auth.email)) {
            throw GraphQLRequestError("User with this email is already registered")
        }
        val user = userService.createUser(name, auth.email, auth.password)
        return UserDto(user.id, user.fullName, user.email)
    }

    fun loginUser(auth: AuthData): SigninPayload {
        try {
            return authService.authenticate(auth.email, auth.password)
        } catch (e: AuthenticationException) {
            throw GraphQLRequestError("Invalid credentials")
        }
    }
}