package io.whip.graphql.mutation

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import graphql.schema.DataFetchingEnvironment
import io.whip.domain.vehicle.Drivetrain
import io.whip.domain.vehicle.EngineType
import io.whip.domain.vehicle.Transmission
import io.whip.domain.vehicle.Vehicle
import io.whip.exception.GraphQLRequestError
import io.whip.graphql.context.AuthContext
import io.whip.service.BlogService
import io.whip.service.VehicleService
import io.whip.service.VehicleSpecService
import org.springframework.stereotype.Service


/**
 *  Created by Pavel Laktiushkin on 14.03.2019
 */
@Service
class VehicleMutationResolver(val vehicleService: VehicleService,
                              val vehicleSpecService: VehicleSpecService,
                              val blogService: BlogService) : GraphQLMutationResolver {


    fun createVehicle(name: String?, description: String?, year: Int, ownedSince: Int, ownedTo: Int?,
                      generationId: String, displacement: Float?, engineType: EngineType?, transmission: Transmission?, drivetrain: Drivetrain?,
                      horsepower: Int?, env: DataFetchingEnvironment): String? {
        val user = env.getContext<AuthContext>().user ?: throw GraphQLRequestError("Unauthorized")

        // Validations
        val generation = vehicleSpecService.getGeneration(generationId) ?: throw GraphQLRequestError("Vehicle generation not found by id")
        val vehicle = Vehicle(owner = user, name = name, description = description, year = year, ownedSince = ownedSince, ownedTo = ownedTo,
                model = generation.model, generation = generation, displacement = displacement, engineType = engineType, transmission = transmission,
                driveTrain = drivetrain, horsepower = horsepower)

        val result = vehicleService.persistVehicle(vehicle)

        return result.id
    }

}
