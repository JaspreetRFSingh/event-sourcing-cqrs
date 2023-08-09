package com.eventsourcing.projection;
import com.eventsourcing.core.DomainEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.*;
@Component
@Slf4j
public class ReadModelProjection implements Projection {
    @Override public String getName() { return "read-model"; }
    @Override public void handle(DomainEvent event) {
        log.info("Updating read model with event: {}", event.getEventType());
    }
}
