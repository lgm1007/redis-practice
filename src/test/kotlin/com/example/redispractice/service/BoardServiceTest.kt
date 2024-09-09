package com.example.redispractice.service

import com.example.redispractice.persistence.entity.Board
import com.example.redispractice.persistence.repository.BoardRepository
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BoardServiceTest(
    @Autowired var boardService: BoardService,
    @Autowired var boardRepository: BoardRepository,
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
}