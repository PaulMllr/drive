package io.codenetics.drive.graphql.query

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import graphql.schema.DataFetchingEnvironment
import io.codenetics.drive.domain.vehicle.Vehicle
import io.codenetics.drive.exception.GraphQLRequestError
import io.codenetics.drive.graphql.context.AuthContext
import io.codenetics.drive.graphql.dto.GenerationDto
import io.codenetics.drive.graphql.dto.ModelDto
import io.codenetics.drive.graphql.dto.VehicleDto
import io.codenetics.drive.service.VehicleService
import org.springframework.stereotype.Service

/**
 *  Created by Pavel Laktiushkin on 14.03.2019
 */
@Service
class VehicleQueryResolver(val vehicleService: VehicleService) : GraphQLQueryResolver {


    fun getOwnVehicles(env: DataFetchingEnvironment): List<VehicleDto> {
        val user = env.getContext<AuthContext>().user ?: throw GraphQLRequestError("Unauthorized")

        return vehicleService.getVehiclesByOwner(user).map { vehicleToDto(it) }.toList()
    }


    private fun vehicleToDto(vehicle: Vehicle): VehicleDto = VehicleDto(vehicle.id, vehicle.createdAt, vehicle.name,
            vehicle.description, vehicle.owner.fullName, vehicle.year, vehicle.ownedSince, vehicle.ownedTo,
            ModelDto(vehicle.model.id, vehicle.model.name, vehicle.model.market, emptyList()),
            GenerationDto(vehicle.generation.id, vehicle.generation.name, vehicle.generation.yearStart, vehicle.generation.yearEnd),
            vehicle.displacement, vehicle.engineType, vehicle.transmission,
            vehicle.driveTrain, vehicle.horsepower)

}