package com.eventsourcing.command;
import com.eventsourcing.core.DomainEvent;
import com.eventsourcing.eventstore.EventStore;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.*;
import java.util.*;
@Component
@RequiredArgsConstructor
@Slf4j
public class CommandHandler {
    private final EventStore eventStore;
    public void handle(Command command) {
        log.info("Handling command: {}", command.getCommandType());
        List<DomainEvent> events = new ArrayList<>();
        events.add(DomainEvent.builder()
                .aggregateId(command.getAggregateId())
                .eventType(command.getCommandType())
                .payload(command.getPayload())
                .build());
        eventStore.save(command.getAggregateId(), events);
    }
}
