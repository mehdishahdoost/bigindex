package com.github.mehdishahdoost.stockservice.model

import java.time.LocalDateTime

data class Stock(val symbol: String, val price: Double, val time: LocalDateTime)