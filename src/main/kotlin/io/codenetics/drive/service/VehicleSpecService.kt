package io.codenetics.drive.service

import io.codenetics.drive.domain.vehicle.Generation
import io.codenetics.drive.domain.vehicle.Manufacturer
import io.codenetics.drive.domain.vehicle.Model
import org.springframework.stereotype.Service

/**
 *  Created by Pavel Laktiushkin on 10.10.2019
 */
@Service
class VehicleSpecService {

    fun getManufacturer(id: String): Manufacturer? {
        return null
    }
    fun getAllManufacturers(id: String): List<Manufacturer> {
        return listOf()
    }

    fun getModel(manufacturer: Manufacturer, id: String): Model? {
        return null
    }

    fun getGeneration(model: Model, id: String): Generation? {
        return null
    }
}