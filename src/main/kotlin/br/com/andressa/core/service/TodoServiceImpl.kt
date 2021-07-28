package br.com.andressa.core.service

import br.com.andressa.core.mappers.TodoConverter
import br.com.andressa.core.model.Todo
import br.com.andressa.core.ports.TodoRepositoryPort
import br.com.andressa.core.ports.TodoServicePort
import java.util.*
import javax.inject.Singleton

@Singleton
class TodoServiceImpl(private val todoRepositoryPort: TodoRepositoryPort): TodoServicePort {


    override fun addTodo(todo: Todo) {
        val todoEntity = TodoConverter.todoToTodoEntity(todo)
        todoRepositoryPort.saveCql(todoEntity)
    }

    override fun updateTodo(id: UUID, todo: Todo) {
        val todoEntity = TodoConverter.todoToTodoEntity(todo)
        todoRepositoryPort.updateCql(id, todoEntity)
    }

    override fun deleteTodo(id: UUID) {
        todoRepositoryPort.deleteCql(id)
    }
}