package io.codenetics.drive.graphql.context

import graphql.servlet.GraphQLContext
import io.codenetics.drive.graphql.dto.UserDto
import javax.servlet.http.HttpServletRequest


/**
 *  Created by Pavel Laktiushkin on 28.09.2019
 */
class AuthContext(val user: UserDto?, httpServletRequest: HttpServletRequest?) : GraphQLContext(httpServletRequest)