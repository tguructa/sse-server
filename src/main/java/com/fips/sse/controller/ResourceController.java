package com.fips.sse.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fips.sse.model.Usage;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

@CrossOrigin(allowedHeaders = "*")
@RestController
public class ResourceController {
	
	
	

	   
    @GetMapping(value = "/event/resources/usage", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Usage> getResourceUsage() {
    
        Random random = new Random();

        return Flux.interval(Duration.ofSeconds(1))
                .map(it -> new Usage(
                        random.nextInt(101),
                        random.nextInt(101),
                        new Date()));

    }
    

	
}
