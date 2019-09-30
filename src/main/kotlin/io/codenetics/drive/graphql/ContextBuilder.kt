package io.codenetics.drive.graphql

import graphql.GraphQLException
import graphql.servlet.GraphQLContext
import graphql.servlet.GraphQLContextBuilder
import io.codenetics.drive.dao.UserDaoImpl
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
    private lateinit var userDao: UserDaoImpl

    override fun build(request: HttpServletRequest?): GraphQLContext {
        val sessionId = request?.getHeader("Authorization")?.replace("Bearer ", "")
        if (null != sessionId) {
            val user = userDao.findByToken(sessionId)
            return AuthContext(user, request)
        }
        throw GraphQLException("Unauthorized")
    }

    override fun build(request: HandshakeRequest?): GraphQLContext {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun build(): GraphQLContext {
        throw GraphQLException("Unauthorized")
    }
}