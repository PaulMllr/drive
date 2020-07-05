package io.whip.exception

import graphql.ErrorType
import graphql.ExceptionWhileDataFetching
import graphql.GraphQLError
import graphql.language.SourceLocation

class GraphQLErrorAdapter(private val error: GraphQLError) : GraphQLError {

    override fun getExtensions(): Map<String, Any>? {
        return error.extensions
    }

    override fun getLocations(): List<SourceLocation>? {
        return error.locations
    }

    override fun getErrorType(): ErrorType? {
        return error.errorType
    }

    override fun getPath(): List<Any>? {
        return error.path
    }

    override fun toSpecification(): Map<String, Any>? {
        return error.toSpecification()
    }

    override fun getMessage(): String? {
        return if (error is ExceptionWhileDataFetching) error.exception.message else error.message
    }
}
