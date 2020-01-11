package io.codenetics.drive.service

import io.codenetics.drive.dao.BlogPostDao
import io.codenetics.drive.dao.VehicleCommentDao
import io.codenetics.drive.domain.User
import io.codenetics.drive.domain.blog.BlogPost
import io.codenetics.drive.domain.blog.VehicleComment
import io.codenetics.drive.domain.vehicle.Vehicle
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

/**
 *  Created by Pavel Laktiushkin on 14.10.2019
 */
@Service
class BlogService(val blogPostDao: BlogPostDao, val vehicleCommentDao: VehicleCommentDao) {

    fun createVehicleBlogPost(vehicle: Vehicle, message: String) = blogPostDao.save(BlogPost(vehicle = vehicle, message = message))


    fun getVehicleBlogPosts(vehicle: Vehicle, pageNum: Int, pageSize: Int): List<BlogPost> {
        return blogPostDao.findAllByVehicleOrderByCreatedAtDesc(vehicle, PageRequest.of(pageNum, pageSize)).content
    }

    fun createVehicleComment(author: User, vehicle: Vehicle, message: String, parentComment: VehicleComment?): VehicleComment {
        return vehicleCommentDao.save(VehicleComment(writtenBy = author, message = message, parent = parentComment, vehicle = vehicle))
    }

    fun findVehicleComment(vehicle: Vehicle, id: String): VehicleComment? {
        return vehicleCommentDao.findFirstByIdAndVehicle(id, vehicle)
    }
}