package com.example.redispractice.service

import com.example.redispractice.persistence.entity.Board
import com.example.redispractice.persistence.repository.BoardRepository
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.redis.core.RedisTemplate
import kotlin.test.assertEquals

@SpringBootTest
class BoardServiceTest(
    @Autowired var boardService: BoardService,
    @Autowired var boardRepository: BoardRepository,
    @Autowired var redisTemplate: RedisTemplate<String, Any>,
) {

    @BeforeEach
    fun setUp() {
        boardRepository.deleteAll()
    }

    @Test
    fun redis_save() {
        val board = createBoard()
        val actual = boardService.save(board)
        assertThat(actual).isNotEmpty()
    }

    private fun createBoard(): Board {
        return Board(title = "게시글", author = "홍길동")
    }

    @Test
    fun redisTemplate_save() {
        val valueOperations = redisTemplate.opsForValue()

        valueOperations.set("string_key", "value_1")

        val value = valueOperations.get("string_key")
        assertEquals("value_1", value)
    }
}