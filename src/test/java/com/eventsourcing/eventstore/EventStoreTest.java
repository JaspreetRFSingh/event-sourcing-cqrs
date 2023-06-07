package com.eventsourcing.eventstore;
import com.eventsourcing.core.DomainEvent;
import org.junit.jupiter.api.Test;
import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
class EventStoreTest {
    @Test void testSaveAndRetrieve() {
        EventStore store = new EventStore();
        DomainEvent event = DomainEvent.builder().aggregateId("agg1").eventType("Created").build();
        store.save("agg1", Arrays.asList(event));
        assertEquals(1, store.getEvents("agg1").size());
    }
}
