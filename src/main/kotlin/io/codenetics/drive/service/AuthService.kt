package io.codenetics.drive.service

import io.codenetics.drive.dao.UserDao
import io.codenetics.drive.dao.UserSessionDao
import io.codenetics.drive.domain.UserSession
import io.codenetics.drive.exception.AuthenticationException
import io.codenetics.drive.graphql.dto.SigninPayload
import io.codenetics.drive.graphql.dto.UserDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.Instant
import java.util.*

/**
 *  Created by Pavel Laktiushkin on 28.09.2019
 */
@Service
class AuthService {

    @Autowired
    private lateinit var userSessionDao: UserSessionDao

    @Autowired
    private lateinit var userDao: UserDao

    fun authenticate(username: String, password: String): SigninPayload {
        val user = userDao.findFirstByEmail(username)
        if (null != user) {
            if (password == user.password) {
                val session = userSessionDao.save(UserSession(UUID.randomUUID().toString(), Instant.now(), user))
                return SigninPayload(session.id, UserDto(user.id, user.fullName, user.email))
            }
        }
        throw AuthenticationException("Invalid username or password")
    }
}