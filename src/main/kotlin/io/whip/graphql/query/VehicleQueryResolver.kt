package io.whip.graphql.query

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import graphql.schema.DataFetchingEnvironment
import io.whip.domain.vehicle.Vehicle
import io.whip.exception.GraphQLRequestError
import io.whip.graphql.context.AuthContext
import io.whip.graphql.dto.BlogPostDto
import io.whip.graphql.dto.UserDto
import io.whip.graphql.dto.VehicleBlogDto
import io.whip.graphql.dto.VehicleDto
import io.whip.service.BlogService
import io.whip.service.VehicleService
import org.springframework.stereotype.Service

/**
 *  Created by Pavel Laktiushkin on 14.03.2019
 */
@Service
class VehicleQueryResolver(val vehicleService: VehicleService,
                           val blogService: BlogService) : GraphQLQueryResolver {


    fun getOwnVehicles(env: DataFetchingEnvironment): List<VehicleDto> {
        val user = env.getContext<AuthContext>().user ?: throw GraphQLRequestError("Unauthorized")

        return vehicleService.getVehiclesByOwner(user).map { vehicleToDto(it) }.toList()
    }

    fun getVehicle(vehicleId: String): VehicleDto {
        val vehicle = getVehicleOrThrowNotFound(vehicleId)
        return vehicleToDto(vehicle)
    }


    fun getVehicleBlog(vehicleId: String, pageNum: Int, pageSize: Int): VehicleBlogDto {
        val vehicle = getVehicleOrThrowNotFound(vehicleId)
        val user = UserDto(vehicle.owner.id, vehicle.owner.fullName, vehicle.owner.email)
        val posts = blogService.getVehicleBlogPosts(vehicle, pageNum, pageSize).map { BlogPostDto(user, it.createdAt, it.message) }.toList()
        return VehicleBlogDto(vehicleToDto(vehicle), posts)
    }


    private fun vehicleToDto(vehicle: Vehicle): VehicleDto = VehicleDto(vehicle.id, vehicle.createdAt, vehicle.name,
            vehicle.description, vehicle.owner.fullName, vehicle.year, vehicle.ownedSince, vehicle.ownedTo, vehicle.model.market,
            vehicle.model.manufacturer.name, vehicle.model.name, vehicle.generation.name,
            vehicle.displacement, vehicle.engineType, vehicle.transmission,
            vehicle.driveTrain, vehicle.horsepower)

    private fun getVehicleOrThrowNotFound(vehicleId: String) =
            vehicleService.getVehicleById(vehicleId) ?: throw GraphQLRequestError("Vehicle not found by id")


}
