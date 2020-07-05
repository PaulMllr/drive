package io.whip.service

import io.whip.dao.VehicleDao
import io.whip.domain.User
import io.whip.domain.vehicle.Vehicle
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

/**
 *  Created by Pavel Laktiushkin on 29.09.2019
 */
@Service
class VehicleService(val vehicleDao: VehicleDao) {

    fun persistVehicle(vehicle: Vehicle): Vehicle {
        return vehicleDao.save(vehicle)
    }

    fun getVehiclesByOwner(owner: User): List<Vehicle> {
        return vehicleDao.findByOwner(owner)
    }

    fun getVehicleById(vehicleId: String): Vehicle? {
        return vehicleDao.findByIdOrNull(vehicleId)
    }

    fun getVehicleByIdAndOwner(vehicleId: String, owner: User): Vehicle? {
        return vehicleDao.findFirstByIdAndOwner(vehicleId, owner)
    }
}
