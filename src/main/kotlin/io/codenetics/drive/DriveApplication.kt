package io.codenetics.drive

import graphql.ExceptionWhileDataFetching
import graphql.GraphQLError
import graphql.servlet.GraphQLErrorHandler
import io.codenetics.drive.exception.GraphQLErrorAdapter
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import java.util.*
import kotlin.streams.toList


@SpringBootApplication
class DriveApplication {


    @Bean
    fun errorHandler(): GraphQLErrorHandler {
        return object : GraphQLErrorHandler {
            override fun processErrors(errors: List<GraphQLError>): List<GraphQLError> {
                val clientErrors = errors
                        .filter { isClientError(it) }
                        .toList()

                val serverErrors = errors.stream()
                        .filter { e -> !isClientError(e) }
                        .map { GraphQLErrorAdapter(it) }
                        .toList()

                val e = ArrayList<GraphQLError>()
                e.addAll(clientErrors)
                e.addAll(serverErrors)
                return e
            }

            protected fun isClientError(error: GraphQLError): Boolean {
                return !(error is ExceptionWhileDataFetching || error is Throwable)
            }
        }
    }


}

fun main(args: Array<String>) {
    runApplication<DriveApplication>(*args)
}
