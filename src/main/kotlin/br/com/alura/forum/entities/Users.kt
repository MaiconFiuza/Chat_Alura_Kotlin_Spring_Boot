package br.com.alura.forum.entities

import jakarta.persistence.*

@Entity
data class Users(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String,
    val email: String,
)