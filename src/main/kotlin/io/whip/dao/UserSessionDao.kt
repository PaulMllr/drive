package io.whip.dao

import io.whip.domain.UserSession
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.Repository
import org.springframework.transaction.annotation.Transactional


@Transactional
interface UserSessionDao : Repository<UserSession, String>, CrudRepository<UserSession, String> {


}
