package io.whip.graphql.entityresolver

import com.coxautodev.graphql.tools.GraphQLResolver
import io.whip.graphql.dto.GenerationDto
import io.whip.graphql.dto.ModelDto
import io.whip.service.VehicleSpecService
import org.springframework.stereotype.Component


/**
 *  Created by Pavel Laktiushkin on 28.09.2019
 */
@Component
class ModelResolver(private val vehicleSpecService: VehicleSpecService) : GraphQLResolver<ModelDto> {
    fun generations(model: ModelDto): List<GenerationDto> {
        return vehicleSpecService.getAllGenerations(model.id).map { GenerationDto(it.id, it.name, it.yearStart, it.yearEnd) }
    }
}
