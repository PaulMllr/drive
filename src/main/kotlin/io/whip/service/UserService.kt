package io.whip.service

import io.whip.dao.UserDao
import io.whip.domain.User
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
        return userDao.save(User(UUID.randomUUID().toString(), Instant.now(), email, password, name, null, null))
    }

    fun existsUserByEmail(email: String): Boolean {
        return userDao.existsByEmail(email)
    }
}
