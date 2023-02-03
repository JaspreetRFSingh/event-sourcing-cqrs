package com.eventsourcing.snapshot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.*;
import java.util.*;
import java.util.concurrent.*;
@Component
@Slf4j
public class SnapshotStore {
    private final Map<String, Snapshot> store = new ConcurrentHashMap<>();
    public void save(Snapshot snapshot) { store.put(snapshot.getAggregateId(), snapshot); }
    public Optional<Snapshot> get(String aggregateId) { return Optional.ofNullable(store.get(aggregateId)); }
}
