package io.codenetics.drive.graphql.query

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import graphql.schema.DataFetchingEnvironment
import io.codenetics.drive.domain.vehicle.Market
import io.codenetics.drive.exception.GraphQLRequestError
import io.codenetics.drive.graphql.dto.GenerationDto
import io.codenetics.drive.graphql.dto.ManufacturerDto
import io.codenetics.drive.graphql.dto.ModelDto
import io.codenetics.drive.service.VehicleSpecService
import org.springframework.stereotype.Service

/**
 *  Created by Pavel Laktiushkin on 14.03.2019
 */
@Service
class VehicleSpecQueryResolver(val vehicleSpecService: VehicleSpecService) : GraphQLQueryResolver {


    fun getManufacturers(env: DataFetchingEnvironment): List<ManufacturerDto> {
        return vehicleSpecService.getAllManufacturers().map { ManufacturerDto(it.id, it.name, emptyList()) }
    }

    fun getModels(manufacturerId: String, market: Market?, env: DataFetchingEnvironment): List<ModelDto> {
        val manufacturer = vehicleSpecService.getManufacturer(manufacturerId) ?: throw GraphQLRequestError("Manufacturer not found by id")
        return vehicleSpecService.getModels(manufacturer, market).map { ModelDto(it.id, it.name, it.market, emptyList()) }
    }

    fun getGenerations(modelId: String, env: DataFetchingEnvironment): List<GenerationDto> {
        val model = vehicleSpecService.getModel(modelId) ?: throw GraphQLRequestError("Model not found by id")
        return vehicleSpecService.getAllGenerations(model).map { GenerationDto(it.id, it.name, it.yearStart, it.yearEnd) }
    }

}