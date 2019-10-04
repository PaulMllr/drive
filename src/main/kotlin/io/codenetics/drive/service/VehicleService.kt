package io.codenetics.drive.service

import io.codenetics.drive.dao.VehicleDao
import io.codenetics.drive.domain.User
import io.codenetics.drive.domain.vehicle.Vehicle
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

/**
 *  Created by Pavel Laktiushkin on 29.09.2019
 */
@Service
class VehicleService {

    @Autowired
    private lateinit var vehicleDao: VehicleDao

    fun getVehiclesByOwner(owner: User): List<Vehicle> {
        return vehicleDao.findByOwner(owner)
    }
}