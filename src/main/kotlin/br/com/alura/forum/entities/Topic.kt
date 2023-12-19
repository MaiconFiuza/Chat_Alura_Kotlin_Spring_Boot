package br.com.alura.forum.entities

import java.time.LocalDateTime

data class Topic(
        val id: Long? = null,
        val title: String,
        val message: String,
        val createdIn: LocalDateTime =  LocalDateTime.now(),
        val course: Course,
        val user: User,
        val status: Status = Status.NOT_ANSWERED,
        val responses: List<Response> = emptyList(),
)
