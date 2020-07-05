package io.whip.graphql.dto

import io.whip.domain.vehicle.Drivetrain
import io.whip.domain.vehicle.EngineType
import io.whip.domain.vehicle.Market
import io.whip.domain.vehicle.Transmission
import java.time.Instant

/**
 *  Created by Pavel Laktiushkin on 28.09.2019
 */
data class VehicleDto(var id: String,
                      var createdAt: Instant,
                      var name: String?,
                      var description: String?,
                      var owner: String,
                      var year: Int,
                      var ownedSince: Int,
                      var ownedTo: Int?,
                      var market: Market?,
                      var manufacturer: String,
                      var model: String,
                      var generation: String,
                      var displacement: Float?,
                      var engineType: EngineType?,
                      var transmission: Transmission?,
                      var drivetrain: Drivetrain?,
                      var horsepower: Int?)
