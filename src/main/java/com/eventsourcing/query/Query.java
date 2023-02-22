package com.eventsourcing.query;
import lombok.*;
@Data
@Builder
public class Query {
    private String queryType;
    private String aggregateId;
}
