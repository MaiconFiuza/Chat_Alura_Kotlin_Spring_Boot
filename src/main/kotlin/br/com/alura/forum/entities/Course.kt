package br.com.alura.forum.entities

import jakarta.persistence.*

@Entity
data class Course(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long? = null,
        val name: String,
        val category: String,
)
