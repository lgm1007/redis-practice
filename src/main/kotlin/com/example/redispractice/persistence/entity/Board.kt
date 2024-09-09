package com.example.redispractice.persistence.entity

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash("Boards")
class Board(
    @Id val id: String,
    var title: String,
    val author: String,
) {
}