package com.eventsourcing.projection;
import com.eventsourcing.core.DomainEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.*;
import java.util.*;
import java.util.concurrent.*;
@Component
@Slf4j
public class ProjectionManager {
    private final List<Projection> projections = new CopyOnWriteArrayList<>();
    public void register(Projection projection) { projections.add(projection); }
    public void processEvent(DomainEvent event) {
        projections.forEach(p -> {
            try { p.handle(event); }
            catch (Exception e) { log.error("Projection {} failed", p.getName(), e); }
        });
    }
}
