package com.github.mehdishahdoost.springbootwebflux;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoTest {

    @Test
    void monoTest() {
        Mono<?> testdata = Mono.just("testdata")
                .then(Mono.error(new RuntimeException("Error")))
                .log();
        testdata.subscribe(System.out::println, e -> System.out.println(e));
    }

    @Test
    void fluxTest() {
        Flux<?> flux = Flux.just("Mongo", "banana", "apple").
                concatWith(Flux.error(new RuntimeException("Error"))).log();
        flux.subscribe(System.out::println, System.out::println);
    }
}
