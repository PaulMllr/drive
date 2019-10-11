package io.codenetics.drive.graphql.mutation

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import graphql.schema.DataFetchingEnvironment
import io.codenetics.drive.domain.vehicle.Drivetrain
import io.codenetics.drive.domain.vehicle.EngineType
import io.codenetics.drive.domain.vehicle.Transmission
import io.codenetics.drive.domain.vehicle.Vehicle
import io.codenetics.drive.exception.GraphQLRequestError
import io.codenetics.drive.graphql.context.AuthContext
import io.codenetics.drive.service.VehicleService
import io.codenetics.drive.service.VehicleSpecService
import org.springframework.stereotype.Service


/**
 *  Created by Pavel Laktiushkin on 14.03.2019
 */
@Service
class VehicleMutationResolver(val vehicleService: VehicleService, val vehicleSpecService: VehicleSpecService) : GraphQLMutationResolver {


    fun createVehicle(name: String?, description: String?, year: Int, ownedSince: Int, ownedTo: Int?, makeId: String, modelId: String,
                      generationId: String, displacement: Float?, engineType: EngineType?, transmission: Transmission?, drivetrain: Drivetrain?,
                      horsepower: Int?, env: DataFetchingEnvironment): String? {
        val user = env.getContext<AuthContext>().user ?: throw GraphQLRequestError("Unauthorized")

        // Validations
        val manufacturer = vehicleSpecService.getManufacturer(makeId) ?: throw GraphQLRequestError("Manufacturer not found by id")
        val model = vehicleSpecService.getModel(manufacturer, modelId) ?: throw GraphQLRequestError("Model not found by manufacturer and id")
        val generation = vehicleSpecService.getGeneration(model, generationId) ?: throw GraphQLRequestError("Generation not found by model and id")
        val vehicle = Vehicle(owner = user, name = name, description = description, year = year, ownedSince = ownedSince, ownedTo = ownedTo,
                model = model, generation = generation, displacement = displacement, engineType = engineType, transmission = transmission,
                driveTrain = drivetrain, horsepower = horsepower)

        val result = vehicleService.persistVehicle(vehicle)

        return result.id
    }
}