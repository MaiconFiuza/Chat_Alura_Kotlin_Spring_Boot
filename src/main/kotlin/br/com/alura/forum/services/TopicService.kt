package br.com.alura.forum.services

import br.com.alura.forum.entities.Course
import br.com.alura.forum.entities.Topic
import br.com.alura.forum.entities.User
import org.springframework.stereotype.Service

@Service
class TopicService {

    fun getTopic(): List<Topic> {
        return listOf(Topic(
                id = 1,
                title = "Dúvida Kotlin",
                message = "Variáveis no Kotlin",
                course = Course(
                        id = 1,
                        name = "Kotlin",
                        category = "Programação",
                ),
                user = User(
                        id = 1,
                        name = "Teste",
                        email = "teste@teste.com"
                )
        ))
    }
}