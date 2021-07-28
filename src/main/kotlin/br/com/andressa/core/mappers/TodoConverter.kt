package br.com.andressa.core.mappers

import br.com.andressa.core.model.Todo
import br.com.andressa.database.entity.TodoEntity
import br.com.andressa.infrastructure.model.EventsInformation
import br.com.andressa.infrastructure.model.TodoEvent

class TodoConverter {
    companion object{
        fun todoEventToTodo(todoEvent: TodoEvent) = Todo(todoEvent.id, todoEvent.date, todoEvent.description, todoEvent.done)

        fun todoToTodoEntity (todo: Todo) = TodoEntity(todo.id, todo.date, todo.description, todo.done)
    }
}