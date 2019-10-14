package io.codenetics.drive.dao

import io.codenetics.drive.domain.blog.BlogPost
import io.codenetics.drive.domain.vehicle.Vehicle
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