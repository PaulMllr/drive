package io.codenetics.drive.service

import io.codenetics.drive.dao.UserDao
import io.codenetics.drive.exception.AuthenticationException
import io.codenetics.drive.graphql.dto.SigninPayload
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *  Created by Pavel Laktiushkin on 28.09.2019
 */
@Service
class AuthService {

    @Autowired
    private lateinit var userDao: UserDao

    fun authenticate(username: String, password: String): SigninPayload {
        val user = userDao.findByUsername(username)
        if (null != user) {
            if (password == ""){
                return SigninPayload("token1", user)
            }
        }
        throw AuthenticationException("Invalid username or password")
    }
}