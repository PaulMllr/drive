package io.codenetics.drive.graphql.query

import com.coxautodev.graphql.tools.GraphQLQueryResolver
import graphql.schema.DataFetchingEnvironment
import io.codenetics.drive.exception.GraphQLRequestError
import io.codenetics.drive.graphql.context.AuthContext
import io.codenetics.drive.graphql.dto.VehicleDto
import io.codenetics.drive.service.VehicleService
import io.codenetics.drive.service.VehicleSpecService
import org.springframework.stereotype.Service
import java.time.ZoneId

/**
 *  Created by Pavel Laktiushkin on 14.03.2019
 */
@Service
class VehicleSpecQueryResolver(val vehicleSpecService: VehicleSpecService) : GraphQLQueryResolver {


    fun getManufacturers(env: DataFetchingEnvironment): List<VehicleDto> {
        val user = env.getContext<AuthContext>().user ?: throw GraphQLRequestError("Unauthorized")

        return vehicleSpecService.getManufacturer()
    }

}