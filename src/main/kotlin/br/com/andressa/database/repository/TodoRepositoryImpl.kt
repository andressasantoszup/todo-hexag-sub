package br.com.andressa.database.repository

import br.com.andressa.core.ports.TodoRepositoryPort
import br.com.andressa.database.entity.TodoEntity
import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.SimpleStatement
import java.util.*
import javax.inject.Singleton

@Singleton
class TodoRepositoryImpl(private val cqlSession: CqlSession): TodoRepositoryPort {


    override fun saveCql(todoEntity: TodoEntity) {
        cqlSession.execute(
            SimpleStatement.newInstance(
                "INSERT INTO todo(id, date, description, done) values (?,?,?,?)",
                UUID.randomUUID(),
                todoEntity.date,
                todoEntity.description,
                todoEntity.done
            )
        )

    }

    override fun updateCql(id: UUID, todoEntity: TodoEntity) {
        cqlSession.execute(
            SimpleStatement.newInstance("UPDATE todo.Todo SET date=?, description=?, done=? WHERE id=?",

                todoEntity.date,
                todoEntity.description,
                todoEntity.done,
                id

            )
        )

    }

    override fun deleteCql(id: UUID) {
        cqlSession.execute(
            SimpleStatement.newInstance("DELETE FROM todo.Todo WHERE id=?",
                id
            )
        )
    }
}