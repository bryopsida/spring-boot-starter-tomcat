/* (C) 2023 */
package io.github.bryopsida.controllers;

import io.github.bryopsida.entities.EchoHistory;
import io.github.bryopsida.services.EchoService;
import java.time.Instant;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/echo")
public class EchoApi {

    final EchoService echoService;

    public EchoApi(EchoService echoService) {
        this.echoService = echoService;
    }

    @GetMapping("/history")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<EchoHistory> history() {
        return echoService.list();
    }

    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.OK)
    public String hello() {
        echoService.recordHistory(
            EchoHistory
                .builder()
                .id(UUID.randomUUID())
                .message("Hello")
                .timestamp(Instant.now())
                .build()
        );
        return "Hello";
    }

    @GetMapping("echo/{str}")
    @ResponseStatus(HttpStatus.OK)
    public String echo(@PathVariable String str) {
        echoService.recordHistory(
            EchoHistory
                .builder()
                .id(UUID.randomUUID())
                .message("Echo: " + str)
                .timestamp(Instant.now())
                .build()
        );
        return "Echo: " + str;
    }

    @GetMapping("echoquery")
    @ResponseStatus(HttpStatus.OK)
    public String echoQuery(@RequestParam("name") String name) {
        this.echoService.recordHistory(
                EchoHistory
                    .builder()
                    .id(UUID.randomUUID())
                    .message("Hello, " + name)
                    .timestamp(Instant.now())
                    .build()
            );
        return "Hello, " + name;
    }
}
