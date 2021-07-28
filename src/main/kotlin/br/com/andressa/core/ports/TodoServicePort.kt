package br.com.andressa.core.ports

import br.com.andressa.core.model.Todo
import java.util.*

interface TodoServicePort {

    fun addTodo(todo: Todo)
    fun updateTodo(id: UUID, todo: Todo)
    fun deleteTodo(id: UUID)
}