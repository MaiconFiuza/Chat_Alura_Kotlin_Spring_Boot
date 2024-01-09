package br.com.alura.forum.entities.mapper

interface Mapper<T,U>  {

    fun map(t: T): U
}