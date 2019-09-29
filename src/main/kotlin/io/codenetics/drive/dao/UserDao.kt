package io.codenetics.drive.dao

import io.codenetics.drive.graphql.dto.User
import org.springframework.stereotype.Service

/**
 *  Created by Pavel Laktiushkin on 28.09.2019
 */
@Service
class UserDao {


    fun saveUser(newUser: User): User {
        return newUser
    }

    fun findByUsername(username: String): User? {
        return null
    }

    fun findByToken(sessionId: String): User? {
        return User("id1","John Doe","test@test.com","")
    }
}