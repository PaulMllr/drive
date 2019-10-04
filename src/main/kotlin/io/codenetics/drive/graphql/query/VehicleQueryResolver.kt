package io.codenetics.drive.graphql.query

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import graphql.schema.DataFetchingEnvironment
import io.codenetics.drive.exception.GraphQLRequestError
import io.codenetics.drive.graphql.context.AuthContext
import io.codenetics.drive.graphql.dto.VehicleDto
import io.codenetics.drive.service.VehicleService
import org.springframework.stereotype.Service
import java.time.ZoneId

/**
 *  Created by Pavel Laktiushkin on 14.03.2019
 */
@Service
class VehicleQueryResolver(val vehicleService: VehicleService) : GraphQLQueryResolver {


    fun getOwnVehicles(env: DataFetchingEnvironment): List<VehicleDto> {
        val user = env.getContext<AuthContext>().user ?: throw GraphQLRequestError("Unauthorized")

        return vehicleService.getVehiclesByOwner(user).map {
            VehicleDto(it.id, it.createdAt, it.name, it.description, it.owner.fullName, it.year,
                    it.ownedSince.atZone(ZoneId.systemDefault()).year, it.ownedTo?.atZone(ZoneId.systemDefault())?.year,
                    it.model.name, it.generation.name, it.displacement, it.engineType?.uiName, it.transmission?.uiName,
                    it.driveTrain?.name, it.horsepower)
        }
                .toList()
    }

}