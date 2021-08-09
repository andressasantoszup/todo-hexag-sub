package br.com.andressa.core.ports

import br.com.andressa.database.entity.TodoEntity
import java.util.*

interface TodoRepositoryPort {

    fun saveCql(todoEntity: TodoEntity)
    fun updateCql (id: UUID, todoEntity: TodoEntity)
    fun deleteCql(id: UUID)
}