package io.codenetics.drive.graphql.type

import graphql.schema.*
import org.springframework.stereotype.Component

import java.time.Instant

@Component
class TimestampType : GraphQLScalarType("Timestamp", "Date type", object : Coercing<Instant, Long> {
    @Throws(CoercingSerializeException::class)
    override fun serialize(dataFetcherResult: Any): Long? {
        return if (dataFetcherResult is Instant) {
            dataFetcherResult.toEpochMilli()
        } else null
    }

    @Throws(CoercingParseValueException::class)
    override fun parseValue(input: Any): Instant {
        return Instant.ofEpochMilli(input as Long)
    }

    @Throws(CoercingParseLiteralException::class)
    override fun parseLiteral(input: Any): Instant {
        return Instant.ofEpochMilli(java.lang.Long.parseLong(input as String))
    }
})
