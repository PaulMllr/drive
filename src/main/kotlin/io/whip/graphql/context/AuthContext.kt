package io.whip.graphql.context

import graphql.servlet.GraphQLContext
import io.whip.domain.User
import javax.servlet.http.HttpServletRequest


/**
 *  Created by Pavel Laktiushkin on 28.09.2019
 */
class AuthContext(val user: User?, httpServletRequest: HttpServletRequest?) : GraphQLContext(httpServletRequest)
