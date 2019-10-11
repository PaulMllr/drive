package io.codenetics.drive.graphql.dto

import io.codenetics.drive.domain.vehicle.Market

/**
 *  Created by Pavel Laktiushkin on 28.09.2019
 */
data class ModelDto(var id: String, var name: String, var market: Market)