package io.codenetics.drive.graphql.type;

import graphql.schema.GraphQLEnumType;
import graphql.schema.GraphQLEnumValueDefinition;
import io.codenetics.drive.domain.vehicle.EngineType;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Component
public class EngineTypeType extends GraphQLEnumType {

    public EngineTypeType() {
        super("EngineType", "", Arrays.stream(EngineType.values())
                .map(it -> new GraphQLEnumValueDefinition(it.name(), "", it)).collect(Collectors.toList()));
    }
}
