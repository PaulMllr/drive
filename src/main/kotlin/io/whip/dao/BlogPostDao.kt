package io.whip.dao

import io.whip.domain.blog.BlogPost
import io.whip.domain.vehicle.Vehicle
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.Repository
import org.springframework.transaction.annotation.Transactional

/**
 *  Created by Pavel Laktiushkin on 03.10.2019
 */
@Transactional
interface BlogPostDao : Repository<BlogPost, String>, CrudRepository<BlogPost, String> {


    fun findAllByVehicleOrderByCreatedAtDesc(vehicle: Vehicle, pageable: Pageable): Page<BlogPost>
}
