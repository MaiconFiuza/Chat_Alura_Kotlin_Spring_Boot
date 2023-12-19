package br.com.alura.forum.controller

import br.com.alura.forum.services.TopicService
import br.com.alura.forum.entities.Topic
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/topic")
class TopicController(
       val topicService: TopicService
) {

    @GetMapping
    fun getTopic(): List<Topic> {
        return topicService.getTopic()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Topic {
        return topicService.getById(id)
    }
}