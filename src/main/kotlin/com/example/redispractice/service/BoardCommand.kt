package com.example.redispractice.service

import com.example.redispractice.persistence.entity.Board

interface BoardCommand {
    fun save(board: Board): String?
}