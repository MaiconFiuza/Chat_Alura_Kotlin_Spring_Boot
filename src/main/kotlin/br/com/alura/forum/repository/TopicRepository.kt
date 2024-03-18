package br.com.alura.forum.repository

import br.com.alura.forum.entities.Topic
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface TopicRepository: JpaRepository<Topic, Long> {

    fun findByCourseName(courseName: String, pagination: Pageable): Page<Topic>

    fun findByAuthorEmail(authorEmail: String, pagination: Pageable): Page<Topic>
}