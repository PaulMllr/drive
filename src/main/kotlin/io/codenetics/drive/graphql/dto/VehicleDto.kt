package io.codenetics.drive.graphql.dto

import com.sun.tools.javah.Gen
import io.codenetics.drive.domain.vehicle.Drivetrain
import io.codenetics.drive.domain.vehicle.EngineType
import io.codenetics.drive.domain.vehicle.Transmission
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
                      var model: ModelDto,
                      var generation: GenerationDto,
                      var displacement: Float?,
                      var engineType: EngineType?,
                      var transmission: Transmission?,
                      var drivetrain: Drivetrain?,
                      var horsepower: Int?)