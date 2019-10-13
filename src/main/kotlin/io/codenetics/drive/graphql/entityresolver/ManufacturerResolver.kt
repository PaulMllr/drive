package io.codenetics.drive.graphql.entityresolver

import com.coxautodev.graphql.tools.GraphQLResolver
import io.codenetics.drive.graphql.dto.ManufacturerDto
import io.codenetics.drive.graphql.dto.ModelDto
import io.codenetics.drive.service.VehicleSpecService
import org.springframework.stereotype.Component


/**
 *  Created by Pavel Laktiushkin on 28.09.2019
 */
@Component
class ManufacturerResolver(private val vehicleSpecService: VehicleSpecService) : GraphQLResolver<ManufacturerDto> {
    fun models(manufacturer: ManufacturerDto): List<ModelDto> {
        return vehicleSpecService.getModels(manufacturer.id, null).map { ModelDto(it.id, it.name, it.market, emptyList()) }
    }
}