package br.com.alura.forum.entities

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "topic")
data class Topic(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    var title: String,
    var message: String,
    val createdIn: LocalDateTime =  LocalDateTime.now(),
    @Enumerated(value = EnumType.STRING)
    val status: Status = Status.NOT_ANSWERED,
    @ManyToOne
    val course: Course,
    @ManyToOne
    val author: Users,
    @OneToMany(mappedBy = "topic")
    val responses: List<Responses> = emptyList(),
)
