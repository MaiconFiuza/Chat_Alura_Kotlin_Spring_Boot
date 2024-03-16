package br.com.alura.forum.repository

import br.com.alura.forum.entities.Topic
import org.springframework.data.jpa.repository.JpaRepository

interface TopicRepository: JpaRepository<Topic, Long> {

    fun findByCourseName(courseName: String): List<Topic>

    fun findByAuthorEmail(authorEmail: String): List<Topic>
}