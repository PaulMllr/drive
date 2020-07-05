package io.whip.graphql.dto

import io.whip.domain.vehicle.Market

/**
 *  Created by Pavel Laktiushkin on 28.09.2019
 */
data class ModelDto(var id: String, var name: String, var market: Market, var generations: List<GenerationDto>)
