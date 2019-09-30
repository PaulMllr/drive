package io.codenetics.drive.graphql.context

import graphql.GraphQLException
import graphql.servlet.GraphQLContext
import graphql.servlet.GraphQLContextBuilder
import io.codenetics.drive.dao.UserSessionDao
import io.codenetics.drive.graphql.dto.UserDto
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import javax.servlet.http.HttpServletRequest
import javax.websocket.server.HandshakeRequest


/**
 *  Created by Pavel Laktiushkin on 28.09.2019
 */
@Component
class ContextBuilder: GraphQLContextBuilder {

    @Autowired
    private lateinit var userSessionDao: UserSessionDao

    override fun build(request: HttpServletRequest?): GraphQLContext {
        val sessionId = request?.getHeader("Authorization")?.replace("Bearer ", "")
        if (null != sessionId) {
            val sessionOpt = userSessionDao.findById(sessionId)
            if (sessionOpt.isPresent) {
                val user = sessionOpt.get().user
                return AuthContext(UserDto(user.id, user.fullName, user.email), request)
            }
        }
        return AuthContext(null, request)
    }

    override fun build(request: HandshakeRequest?): GraphQLContext {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun build(): GraphQLContext {
        throw GraphQLException("Unauthorized")
    }
}