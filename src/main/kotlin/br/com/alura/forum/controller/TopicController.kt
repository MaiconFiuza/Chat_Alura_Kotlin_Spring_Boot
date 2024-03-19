package br.com.alura.forum.controller

import br.com.alura.forum.services.TopicService
import br.com.alura.forum.entities.Topic
import br.com.alura.forum.entities.dto.TopicByCategory
import br.com.alura.forum.entities.dto.TopicDto
import br.com.alura.forum.entities.dto.UpdateTopic
import br.com.alura.forum.entities.view.TopicView
import jakarta.validation.Valid
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.data.web.PageableDefault
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping("/topic")
class TopicController(
       val topicService: TopicService
) {

    @GetMapping
    @Cacheable("topics")
    fun getTopic(
        @RequestParam(required = false) courseName: String?,
        @RequestParam(required = false) authorEmail: String?,
        @PageableDefault(size = 5, sort = ["createdIn"], direction = Sort.Direction.DESC) pagination: Pageable,
    ): Page<TopicView> {
        return topicService.getTopic(courseName, authorEmail, pagination)
    }

    @GetMapping("/report")
    fun getTopicReport(): List<TopicByCategory>{
        return topicService.getReport()
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): Topic {
        return topicService.getById(id)
    }

    @PostMapping
    @Transactional
    @CacheEvict(value = ["topics"], allEntries = true)
    fun postTopic(@RequestBody @Valid topic: TopicDto): ResponseEntity<TopicView> {
        val topicView = topicService.createTopic(topic)
        val uri = URI("/topic/${topicView.id}")

        return ResponseEntity.created(uri).body(topicView)
    }

    @PutMapping
    @Transactional
    @CacheEvict(value = ["topics"], allEntries = true)
    fun updateTopic(@RequestBody @Valid updateTopic: UpdateTopic): ResponseEntity<TopicView> {
        val topicView =  topicService.updateTopic(updateTopic)

        return ResponseEntity.ok(topicView)
    }

    @DeleteMapping("/{id}") 
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    @CacheEvict(value = ["topics"], allEntries = true)
    fun deleteTopic(@PathVariable id: Long){
       topicService.deleteById(id)
    }
}