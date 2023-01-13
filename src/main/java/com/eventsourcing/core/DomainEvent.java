package com.eventsourcing.core;
import lombok.*;
import java.time.*;
import java.util.*;
@Data
@Builder
public class DomainEvent {
    private UUID eventId;
    private String aggregateId;
    private String eventType;
    private String payload;
    private int version;
    private LocalDateTime timestamp;
}
