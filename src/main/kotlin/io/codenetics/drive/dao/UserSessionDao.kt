package io.codenetics.drive.dao

import io.codenetics.drive.domain.UserSession
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.Repository
import org.springframework.transaction.annotation.Transactional


@Transactional
interface UserSessionDao : Repository<UserSession, String>, CrudRepository<UserSession, String> {


}