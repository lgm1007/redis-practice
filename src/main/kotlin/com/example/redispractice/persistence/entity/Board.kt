package com.example.redispractice.persistence.entity

import org.springframework.data.annotation.Id
import org.springframework.data.redis.core.RedisHash

@RedisHash("Boards")
class Board(
    @Id val id: String? = null,
    var title: String,
    var author: String,
) {
    constructor(title: String, author: String) : this(null, title, author) {
        this.title = title
        this.author = author
    }
}