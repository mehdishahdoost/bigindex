package com.github.mehdishahdoost.stockservice.controller

import com.github.mehdishahdoost.stockservice.model.Stock
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import java.time.Duration
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.concurrent.ThreadLocalRandom

@RestController
class StockController {

    @GetMapping(value = ["/stock/{symbol}"], produces = [MediaType.TEXT_EVENT_STREAM_VALUE])
    fun getPrice(@PathVariable symbol: String): Flux<Stock> {
        return Flux.interval(Duration.ofSeconds(1)).map {
            Stock(symbol, randomPrice(), LocalDateTime.now());
        }
    }

    private fun randomPrice(): Double {
        return ThreadLocalRandom.current().nextDouble(100.0);
    }

}