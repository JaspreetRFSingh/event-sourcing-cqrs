package com.eventsourcing.query;
import com.eventsourcing.core.DomainEvent;
import com.eventsourcing.eventstore.EventStore;
import lombok.*;
import org.springframework.stereotype.*;
import java.util.*;
@Component
@RequiredArgsConstructor
public class QueryHandler {
    private final EventStore eventStore;
    public List<DomainEvent> handle(Query query) {
        return eventStore.getEvents(query.getAggregateId());
    }
}
