package com.eventsourcing.controller;
import com.eventsourcing.command.Command;
import com.eventsourcing.command.CommandHandler;
import com.eventsourcing.query.Query;
import com.eventsourcing.query.QueryHandler;
import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/events")
@RequiredArgsConstructor
public class EventSourcingController {
    private final CommandHandler commandHandler;
    private final QueryHandler queryHandler;
    @PostMapping("/commands")
    public ResponseEntity<Void> handleCommand(@RequestBody Command command) {
        commandHandler.handle(command);
        return ResponseEntity.accepted().build();
    }
    @PostMapping("/queries")
    public ResponseEntity<Object> handleQuery(@RequestBody Query query) {
        return ResponseEntity.ok(queryHandler.handle(query));
    }
}
