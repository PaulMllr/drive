package io.whip.dao

import io.whip.domain.vehicle.Manufacturer
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.Repository
import org.springframework.transaction.annotation.Transactional

/**
 *  Created by Pavel Laktiushkin on 03.10.2019
 */
@Transactional
interface ManufacturerDao : Repository<Manufacturer, String>, CrudRepository<Manufacturer, String> {


}
