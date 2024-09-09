package com.example.redispractice.persistence.repository

import com.example.redispractice.persistence.entity.Board
import org.springframework.data.repository.CrudRepository

interface BoardRepository : CrudRepository<Board, String> {
}