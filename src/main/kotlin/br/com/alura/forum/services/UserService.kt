package br.com.alura.forum.services

import br.com.alura.forum.entities.User
import org.springframework.stereotype.Service

@Service
class UserService(
    private var user: List<User> = ArrayList()
){
    init {
        user = listOf(User(
                id = 1,
                name = "Fifiuzinha",
                email = "Programation"
        ), User(
                id = 2,
                name = "AWS",
                email = "Nuvem"
        ))
    }


    fun findById(id: Long): User {
        return user.stream().filter { c -> c.id == id }.findFirst().get()
    }
}