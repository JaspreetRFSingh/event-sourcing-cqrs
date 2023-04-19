package com.eventsourcing.service;
import com.eventsourcing.core.DomainEvent;
import com.eventsourcing.eventstore.EventStore;
import com.eventsourcing.snapshot.SnapshotStore;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.*;
import java.util.*;
@Component
@RequiredArgsConstructor
@Slf4j
public class EventReplayer {
    private final EventStore eventStore;
    private final SnapshotStore snapshotStore;
    public List<DomainEvent> replay(String aggregateId) {
        log.info("Replaying events for aggregate: {}", aggregateId);
        return eventStore.getEvents(aggregateId);
    }
}
