package br.com.alura.forum.services

import br.com.alura.forum.entities.Course
import br.com.alura.forum.entities.Topic
import br.com.alura.forum.entities.User
import org.springframework.stereotype.Service

@Service
class TopicService(
        private var topics: List<Topic>
) {
    init {
       val topic1 =  Topic(
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
        )
        val topic2 =  Topic(
                id = 2,
                title = "Dúvida Spring",
                message = "Injeção de depêndencia",
                course = Course(
                        id = 2,
                        name = "Spring Boot",
                        category = "Programação",
                ),
                user = User(
                        id = 2,
                        name = "OutroTeste",
                        email = "outroteste@teste.com"
                )
        )

        topics = listOf(topic1, topic2)
    }
    fun getTopic(): List<Topic> {
        return topics
    }

    fun getById(id: Long): Topic {
        return topics.first { it.id == id }
    }
}