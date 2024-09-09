package com.example.redispractice.persistence.entity

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash("Boards")
class Board(
    var title: String,
    var author: String,
) {
    @Id var id: String? = null
        private set
}