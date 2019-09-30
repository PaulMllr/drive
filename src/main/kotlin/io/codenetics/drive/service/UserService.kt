package io.codenetics.drive.service

import io.codenetics.drive.dao.UserDao
import io.codenetics.drive.domain.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.Instant
import java.util.*

/**
 *  Created by Pavel Laktiushkin on 29.09.2019
 */
@Service
class UserService {

    @Autowired
    private lateinit var userDao: UserDao

    fun createUser(name: String, email: String, password: String): User {
        return userDao.save(User(UUID.randomUUID().toString(), Instant.now(), email, password, name))
    }

    fun existsUserByEmail(email: String): Boolean {
        return userDao.existsByEmail(email)
    }
}