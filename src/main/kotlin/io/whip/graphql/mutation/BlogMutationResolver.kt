package io.whip.graphql.mutation

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import graphql.schema.DataFetchingEnvironment
import io.whip.exception.GraphQLRequestError
import io.whip.graphql.context.AuthContext
import io.whip.service.BlogService
import io.whip.service.VehicleService
import org.springframework.stereotype.Service


/**
 *  Created by Pavel Laktiushkin on 08.01.2020
 */
@Service
class BlogMutationResolver(val vehicleService: VehicleService,
                           val blogService: BlogService) : GraphQLMutationResolver {


    fun createVehiclePost(vehicleId: String, message: String, env: DataFetchingEnvironment): String {
        val user = env.getContext<AuthContext>().user ?: throw GraphQLRequestError("Unauthorized")
        val vehicle = vehicleService.getVehicleByIdAndOwner(vehicleId, user) ?: throw GraphQLRequestError("Vehicle not found")
        val result = blogService.createVehicleBlogPost(vehicle, message)
        return result.id
    }

    fun createVehicleComment(vehicleId: String, message: String, parentCommentId: String?, env: DataFetchingEnvironment): String {
        val user = env.getContext<AuthContext>().user ?: throw GraphQLRequestError("Unauthorized")
        val vehicle = vehicleService.getVehicleById(vehicleId) ?: throw GraphQLRequestError("Vehicle not found")
        val parentComment = if (parentCommentId != null) {
            blogService.findVehicleComment(vehicle, parentCommentId)
                    ?: throw GraphQLRequestError("Parent comment not found")
        } else null

        val result = blogService.createVehicleComment(user, vehicle, message, parentComment)
        return result.id

    }
}
