package com.eventsourcing.service;
import com.eventsourcing.snapshot.Snapshot;
import com.eventsourcing.snapshot.SnapshotStore;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.*;
import java.time.LocalDateTime;
@Service
@RequiredArgsConstructor
@Slf4j
public class SnapshotService {
    private final SnapshotStore snapshotStore;
    public void createSnapshot(String aggregateId, String state, int version) {
        Snapshot snapshot = Snapshot.builder()
                .aggregateId(aggregateId).state(state).version(version)
                .createdAt(LocalDateTime.now()).build();
        snapshotStore.save(snapshot);
        log.info("Created snapshot for aggregate {} at version {}", aggregateId, version);
    }
}
