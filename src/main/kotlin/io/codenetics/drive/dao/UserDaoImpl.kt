package io.codenetics.drive.dao

import io.codenetics.drive.graphql.dto.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import javax.persistence.EntityManager

/**
 *  Created by Pavel Laktiushkin on 28.09.2019
 */

class UserDaoImpl {

    @Autowired
    private lateinit var em: EntityManager

    fun saveUser(user: User): User {
        return em.merge(user)
    }

    fun findByUsername(username: String): User? {
      return null
    }

    fun findByToken(sessionId: String): User? {
        return null
    }
}