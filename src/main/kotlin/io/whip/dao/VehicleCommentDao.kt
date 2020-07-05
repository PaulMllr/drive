package io.whip.dao

import io.whip.domain.blog.VehicleComment
import io.whip.domain.vehicle.Vehicle
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.Repository

/**
 *  Created by Pavel Laktiushkin on 08.01.2020
 */
interface VehicleCommentDao : Repository<VehicleComment, String>, CrudRepository<VehicleComment, String> {

    fun findFirstByIdAndVehicle(id: String, vehicle: Vehicle): VehicleComment?


}
