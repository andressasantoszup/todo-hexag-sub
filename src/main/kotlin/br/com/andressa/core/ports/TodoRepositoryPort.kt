package br.com.andressa.core.ports

import br.com.andressa.database.entity.TodoEntity
import java.util.*

interface TodoRepositoryPort {

    fun saveCql(todoEntity: TodoEntity): TodoEntity
    fun updateCql (id: UUID, todoEntity: TodoEntity): TodoEntity
    fun deleteCql(id: UUID)
}