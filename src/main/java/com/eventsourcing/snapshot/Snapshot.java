package com.eventsourcing.snapshot;
import lombok.*;
import java.time.*;
@Data
@Builder
public class Snapshot {
    private String aggregateId;
    private String state;
    private int version;
    private LocalDateTime createdAt;
}
