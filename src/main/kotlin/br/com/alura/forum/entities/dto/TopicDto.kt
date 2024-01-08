package br.com.alura.forum.entities.dto

data class TopicDto(
        val title: String,
        val message: String,
        val idCourse: Long,
        val idAuthor: Long,
)
