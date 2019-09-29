package io.codenetics.drive.graphql

import graphql.servlet.GraphQLContext
import io.codenetics.drive.graphql.dto.User
import javax.servlet.http.HttpServletRequest


/**
 *  Created by Pavel Laktiushkin on 28.09.2019
 */
class AuthContext(val user: User?, httpServletRequest: HttpServletRequest?) : GraphQLContext(httpServletRequest)