package br.com.alura.forum.repository

import br.com.alura.forum.entities.Topic
import br.com.alura.forum.entities.dto.TopicByCategory
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query

interface TopicRepository: JpaRepository<Topic, Long> {

    fun findByCourseName(courseName: String, pagination: Pageable): Page<Topic>
    fun findByAuthorEmail(authorEmail: String, pagination: Pageable): Page<Topic>

    @Query("SELECT new br.com.alura.forum.entities.dto.TopicByCategory(course.category, count(t)) FROM Topic t JOIN t.course course GROUP BY course.category")
    fun report(): List<TopicByCategory>
}