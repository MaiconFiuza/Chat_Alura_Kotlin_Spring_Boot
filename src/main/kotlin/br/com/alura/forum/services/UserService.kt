package br.com.alura.forum.services

import br.com.alura.forum.entities.Users
import br.com.alura.forum.exception.NotFoundException
import br.com.alura.forum.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
    private val notFoundException: String = "Usuário não encontrado"
){
    fun findById(id: Long): Users {
        return userRepository.findById(id).orElseThrow{ throw NotFoundException(notFoundException) }
    }
}