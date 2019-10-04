package io.codenetics.drive.graphql.type;

import graphql.schema.*;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class TimestampType extends GraphQLScalarType {
    public TimestampType() {
        super("Timestamp", "Date type", new Coercing<Instant, Long>() {
            @Override
            public Long serialize(Object dataFetcherResult) throws CoercingSerializeException {
                if (dataFetcherResult instanceof Instant) {
                    return ((Instant) dataFetcherResult).toEpochMilli();
                }
                return null;
            }

            @Override
            public Instant parseValue(Object input) throws CoercingParseValueException {
                return Instant.ofEpochMilli((Long) input);
            }

            @Override
            public Instant parseLiteral(Object input) throws CoercingParseLiteralException {
                return Instant.ofEpochMilli(Long.parseLong((String) input));
            }
        });
    }
}
