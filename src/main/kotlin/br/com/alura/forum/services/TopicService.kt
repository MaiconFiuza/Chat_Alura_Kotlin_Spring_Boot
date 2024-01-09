package br.com.alura.forum.services

import br.com.alura.forum.entities.Topic
import br.com.alura.forum.entities.dto.TopicDto
import br.com.alura.forum.entities.mapper.TopicMapper
import br.com.alura.forum.entities.view.TopicView
import org.springframework.stereotype.Service

@Service
class TopicService(
        private var topics: List<Topic> = ArrayList(),
        private val courseService: CourseService,
        private val userService: UserService,
        private val topicMapper: TopicMapper,
) {
    fun getTopic(): List<TopicView> {
        return topics.map { topic -> topicMapper.map(topic) }
    }

    fun getById(id: Long): Topic {
        return topics.first { it.id == id }
    }

    fun createTopic(topic: TopicDto): TopicView {
        val newTopic = Topic(
                id = (topics.size + 1).toLong(),
                title = topic.title,
                message = topic.message,
                course = courseService.findById(id = topic.idCourse),
                user = userService.findById(id = topic.idAuthor)
        )
         topics = topics.plus(newTopic)
        return topicMapper.map(newTopic)
    }
}