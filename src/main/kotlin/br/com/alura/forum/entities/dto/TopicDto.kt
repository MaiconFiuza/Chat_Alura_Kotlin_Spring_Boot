package br.com.alura.forum.entities.dto

import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Size

data class TopicDto(
        @field:NotEmpty
        @field:Size(min = 3, max = 25)
        val title: String,
        @field:NotEmpty
        val message: String,
        @field:NotNull
        val idCourse: Long,
        @field:NotNull
        val idAuthor: Long,
)
