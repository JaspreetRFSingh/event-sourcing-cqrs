package com.eventsourcing.config;
import lombok.*;
import org.springframework.boot.context.properties.*;
import org.springframework.context.annotation.*;
@Configuration
@ConfigurationProperties(prefix = "eventsourcing")
@Data
public class EventSourcingConfig {
    private int snapshotInterval = 100;
    private boolean replayEnabled = true;
}
