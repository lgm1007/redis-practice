package com.example.redispractice.persistence.entity

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash("Boards")
class Board(
    @Id private val id: String,
    private var title: String,
    private val author: String,
) {
}