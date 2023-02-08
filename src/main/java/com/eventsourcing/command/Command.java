package com.eventsourcing.command;
import lombok.*;
import java.util.*;
@Data
@Builder
public class Command {
    private UUID commandId;
    private String aggregateId;
    private String commandType;
    private String payload;
}
