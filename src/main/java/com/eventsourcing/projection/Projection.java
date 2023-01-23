package com.eventsourcing.projection;
import com.eventsourcing.core.DomainEvent;
public interface Projection {
    void handle(DomainEvent event);
    String getName();
}
