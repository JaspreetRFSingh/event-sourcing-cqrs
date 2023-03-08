package com.eventsourcing.service;
import com.eventsourcing.core.DomainEvent;
import com.eventsourcing.projection.ProjectionManager;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.*;
@Component
@RequiredArgsConstructor
@Slf4j
public class EventPublisher {
    private final ProjectionManager projectionManager;
    public void publish(DomainEvent event) {
        log.info("Publishing event: {}", event.getEventType());
        projectionManager.processEvent(event);
    }
}
