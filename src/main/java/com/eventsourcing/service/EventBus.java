package com.eventsourcing.service;
import com.eventsourcing.core.DomainEvent;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.*;
import java.util.*;
import java.util.concurrent.*;
@Component
@Slf4j
public class EventBus {
    private final List<java.util.function.Consumer<DomainEvent>> subscribers = new CopyOnWriteArrayList<>();
    public void subscribe(java.util.function.Consumer<DomainEvent> handler) { subscribers.add(handler); }
    public void publish(DomainEvent event) { subscribers.forEach(h -> h.accept(event)); }
}
