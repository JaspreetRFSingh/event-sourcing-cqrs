package com.eventsourcing.core;
import java.util.*;
public abstract class Aggregate {
    private final List<DomainEvent> uncommittedEvents = new ArrayList<>();
    public List<DomainEvent> getUncommittedEvents() { return uncommittedEvents; }
    public void clearUncommittedEvents() { uncommittedEvents.clear(); }
    protected void applyEvent(DomainEvent event) {
        uncommittedEvents.add(event);
    }
}
