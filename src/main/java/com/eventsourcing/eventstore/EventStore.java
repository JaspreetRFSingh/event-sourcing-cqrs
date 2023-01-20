package com.eventsourcing.eventstore;
import com.eventsourcing.core.DomainEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.*;
import java.util.*;
import java.util.concurrent.*;
@Component
@Slf4j
public class EventStore {
    private final Map<String, List<DomainEvent>> store = new ConcurrentHashMap<>();
    public void save(String aggregateId, List<DomainEvent> events) {
        store.computeIfAbsent(aggregateId, k -> new ArrayList<>()).addAll(events);
        log.info("Saved {} events for aggregate {}", events.size(), aggregateId);
    }
    public List<DomainEvent> getEvents(String aggregateId) {
        return store.getOrDefault(aggregateId, Collections.emptyList());
    }
}
