package com.example.redispractice.service

import com.example.redispractice.persistence.entity.Board
import com.example.redispractice.persistence.repository.BoardRepository
import lombok.RequiredArgsConstructor
import org.springframework.stereotype.Service

@Service
@RequiredArgsConstructor
class BoardService(
    private val boardRepository: BoardRepository,
) : BoardCommand {

    override fun save(board: Board): String? {
        return boardRepository.save(board).id
    }
}