package io.codenetics.drive.dao

import io.codenetics.drive.domain.User
import io.codenetics.drive.domain.vehicle.Vehicle
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.Repository
import org.springframework.transaction.annotation.Transactional

/**
 *  Created by Pavel Laktiushkin on 03.10.2019
 */
@Transactional
interface VehicleDao : Repository<Vehicle, String>, CrudRepository<Vehicle, String> {

    fun findByOwner(owner: User): List<Vehicle>
}