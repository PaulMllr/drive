package io.codenetics.drive.graphql

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import graphql.GraphQLException
import graphql.schema.DataFetchingEnvironment
import io.codenetics.drive.dao.UserDao
import io.codenetics.drive.exception.AuthenticationException
import io.codenetics.drive.graphql.dto.AuthData
import io.codenetics.drive.graphql.dto.SigninPayload
import io.codenetics.drive.graphql.dto.User
import io.codenetics.drive.service.AuthService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


/**
 *  Created by Pavel Laktiushkin on 14.03.2019
 */
@Service
class MutationResolver : GraphQLMutationResolver {

    @Autowired
    private lateinit var userDao: UserDao

    @Autowired
    private lateinit var authService: AuthService

    fun createUser(name: String, auth: AuthData): User {
        val newUser = User("", name, auth.email, auth.password)
        return userDao.saveUser(newUser)
    }

    fun signinUser(auth: AuthData): SigninPayload {
        try {
            return authService.authenticate(auth.email, auth.password)
        } catch (e: AuthenticationException) {
            throw GraphQLException("Invalid credentials")
        }
    }

    fun createVehicle(name: String, env: DataFetchingEnvironment): String {
        val user = env.getContext<AuthContext>().user ?: throw GraphQLException("Unauthorized")
        return name
    }
}