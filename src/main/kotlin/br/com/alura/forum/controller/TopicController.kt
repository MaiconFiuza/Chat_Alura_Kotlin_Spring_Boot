package br.com.alura.forum.controller

import br.com.alura.forum.services.TopicService
import br.com.alura.forum.entities.Topic
import br.com.alura.forum.entities.dto.TopicDto
import br.com.alura.forum.entities.dto.UpdateTopic
import br.com.alura.forum.entities.view.TopicView
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping("/topic")
class TopicController(
       val topicService: TopicService
) {

    @GetMapping
    fun getTopic(): List<TopicView> {
        return topicService.getTopic()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Topic {
        return topicService.getById(id)
    }

    @PostMapping
    @Transactional
    fun postTopic(@RequestBody @Valid topic: TopicDto): ResponseEntity<TopicView> {
        val topicView = topicService.createTopic(topic)
        val uri = URI("/topic/${topicView.id}")

        return ResponseEntity.created(uri).body(topicView)
    }

    @PutMapping
    @Transactional
    fun updateTopic(@RequestBody @Valid updateTopic: UpdateTopic): ResponseEntity<TopicView> {
        val topicView =  topicService.updateTopic(updateTopic)

        return ResponseEntity.ok(topicView)
    }

    @DeleteMapping("/{id}") 
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    fun deleteTopic(@PathVariable id: Long){
       topicService.deleteById(id)
    }
}