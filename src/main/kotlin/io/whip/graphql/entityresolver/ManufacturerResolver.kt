package io.whip.graphql.entityresolver

import com.coxautodev.graphql.tools.GraphQLResolver
import io.whip.graphql.dto.ManufacturerDto
import io.whip.graphql.dto.ModelDto
import io.whip.service.VehicleSpecService
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
