package br.com.alura.forum.services

import br.com.alura.forum.entities.Topic
import br.com.alura.forum.entities.dto.TopicDto
import br.com.alura.forum.entities.dto.UpdateTopic
import br.com.alura.forum.entities.mapper.TopicMapper
import br.com.alura.forum.entities.view.TopicView
import br.com.alura.forum.exception.NotFoundException
import br.com.alura.forum.repository.TopicRepository
import org.springframework.stereotype.Service

@Service
class TopicService(
        private val topicRepository: TopicRepository,
        private val courseService: CourseService,
        private val userService: UserService,
        private val topicMapper: TopicMapper,
        private val notFoundException: String = "Id não encontrado"
) {
    fun getTopic(): List<TopicView> {
        return topicRepository.findAll().map { topic -> topicMapper.map(topic) }
    }

    fun getById(id: Long): Topic {
        return topicRepository.findById(id).orElseThrow {
            throw NotFoundException(notFoundException)
        }
    }

    fun createTopic(topic: TopicDto): TopicView {
        val size = topicRepository.findAll().size
        val newTopic = Topic(
                id = (size + 1).toLong(),
                title = topic.title,
                message = topic.message,
                course = courseService.findById(id = topic.idCourse),
                author = userService.findById(id = topic.idAuthor)
        )
        topicRepository.save(newTopic)
        return topicMapper.map(newTopic)
    }

    fun updateTopic(updateTopic: UpdateTopic): TopicView {
        val topic = topicRepository.findById(updateTopic.id).orElseThrow {
            throw NotFoundException(notFoundException)
        }

        topic.title = updateTopic.title
        topic.message = updateTopic.menssage

        return topicMapper.map(topic)
    }

    fun deleteById(id: Long) {
       topicRepository.deleteById(id)
    }
}