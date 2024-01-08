package br.com.alura.forum.services

import br.com.alura.forum.entities.Course
import org.springframework.stereotype.Service

@Service
class CourseService(
        private var course: List<Course> = ArrayList()
){
    init {
     course = listOf(Course(
                id = 1,
                name = "Kotlin",
                category = "Programation"
        ), Course(
                id = 2,
                name = "AWS",
                category = "Nuvem"
        ))
    }


    fun findById(id: Long): Course {
       return course.stream().filter { c -> c.id == id }.findFirst().get()
    }
}