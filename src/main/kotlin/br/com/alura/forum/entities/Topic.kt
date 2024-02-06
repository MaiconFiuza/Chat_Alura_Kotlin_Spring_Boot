package br.com.alura.forum.entities

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
data class Topic(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        val title: String,
        val message: String,
        val createdIn: LocalDateTime =  LocalDateTime.now(),
        @ManyToOne
        val course: Course,
        @ManyToOne
        val user: User,
        @Enumerated(value = EnumType.STRING)
        val status: Status = Status.NOT_ANSWERED,
        @OneToMany(mappedBy = "topic")
        val responses: List<Response> = emptyList(),
)
