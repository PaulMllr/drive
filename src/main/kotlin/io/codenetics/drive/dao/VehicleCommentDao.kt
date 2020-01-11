package io.codenetics.drive.dao

import io.codenetics.drive.domain.blog.VehicleComment
import io.codenetics.drive.domain.vehicle.Vehicle
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.Repository

/**
 *  Created by Pavel Laktiushkin on 08.01.2020
 */
interface VehicleCommentDao : Repository<VehicleComment, String>, CrudRepository<VehicleComment, String> {

    fun findFirstByIdAndVehicle(id: String, vehicle: Vehicle): VehicleComment?


}