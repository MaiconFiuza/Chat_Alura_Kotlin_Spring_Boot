package br.com.alura.forum.services

import br.com.alura.forum.entities.Course
import br.com.alura.forum.exception.NotFoundException
import br.com.alura.forum.repository.CourseRepository
import org.springframework.stereotype.Service

@Service
class CourseService(
        private val courseRepository: CourseRepository,
){
    private val notFoundException: String = "Id não encontrado"

    fun findById(id: Long): Course {
       return courseRepository.findById(id).orElseThrow {
           throw NotFoundException(notFoundException)
       }
    }
}