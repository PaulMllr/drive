package io.codenetics.drive.dao

import io.codenetics.drive.domain.User
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.Repository
import org.springframework.transaction.annotation.Transactional

/**
 *  Created by Pavel Laktiushkin on 29.09.2019
 */
@Transactional
interface UserDao : Repository<User, String>, CrudRepository<User, String> {
    fun findFirstByEmail(username: String): User?

    fun existsByEmail(email: String): Boolean

}