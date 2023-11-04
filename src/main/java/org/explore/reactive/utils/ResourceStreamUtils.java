package org.explore.reactive.utils;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class ResourceStreamUtils {

    private ResourceStreamUtils() {}

    public static Mono<String> stringMono() {
        return Mono.just("Deshpande Anoop")
                .delayElement(Duration.ofSeconds(2L));
    }

    public static Flux<String> stringFlux() {
        return Flux.fromIterable(Arrays.asList("John", "Annie", "Dorse", "Jack"))
                .delayElements(Duration.ofSeconds(2L));
    }

    public static Mono<String> errorStringMono() {
        return Mono.error(new IllegalArgumentException("Invalid element"));
    }
}
