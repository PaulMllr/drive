package io.codenetics.drive.graphql.context

import graphql.servlet.GraphQLContext
import io.codenetics.drive.domain.User
import javax.servlet.http.HttpServletRequest


/**
 *  Created by Pavel Laktiushkin on 28.09.2019
 */
class AuthContext(val user: User?, httpServletRequest: HttpServletRequest?) : GraphQLContext(httpServletRequest)