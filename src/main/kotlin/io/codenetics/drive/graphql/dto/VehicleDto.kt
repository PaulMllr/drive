package io.codenetics.drive.graphql.dto

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
                      var model: String,
                      var generation: String,
                      var displacement: Float?,
                      var engineType: String?,
                      var transmission: String?,
                      var driveTrain: String?,
                      var horsepower: Int?)