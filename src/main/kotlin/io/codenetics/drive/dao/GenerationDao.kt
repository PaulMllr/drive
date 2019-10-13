package io.codenetics.drive.dao

import io.codenetics.drive.domain.vehicle.Generation
import io.codenetics.drive.domain.vehicle.Model
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.Repository
import org.springframework.transaction.annotation.Transactional

/**
 *  Created by Pavel Laktiushkin on 03.10.2019
 */
@Transactional
interface GenerationDao : Repository<Generation, String>, CrudRepository<Generation, String> {

    fun findFirstByIdAndModel(id: String, model: Model): Generation?

    fun findAllByModel(model: Model): List<Generation>
    fun findAllByModelId(model: String): List<Generation>
}