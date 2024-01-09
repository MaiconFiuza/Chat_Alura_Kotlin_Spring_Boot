package br.com.alura.forum.entities.view

import br.com.alura.forum.entities.Status
import java.time.LocalDateTime

data class TopicView(
        val id: Long? = null,
        val title: String,
        val message: String,
        val createdIn: LocalDateTime =  LocalDateTime.now(),
        val status: Status = Status.NOT_ANSWERED,
)
