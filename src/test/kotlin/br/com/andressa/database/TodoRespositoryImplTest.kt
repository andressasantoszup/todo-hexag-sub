package br.com.andressa.database

import br.com.andressa.database.entity.TodoEntity
import br.com.andressa.database.repository.TodoRepositoryImpl
import com.datastax.oss.driver.api.core.CqlSession
import com.datastax.oss.driver.api.core.cql.ResultSet
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.util.*

@MicronautTest
class TodoRespositoryImplTest: AnnotationSpec() {

    val cqlSession = mockk<CqlSession>(relaxed = true)
    val repo = TodoRepositoryImpl(cqlSession)

    lateinit var todoEntity: TodoEntity
    lateinit var resultSet: ResultSet


    @BeforeEach
    fun setUp(){
        todoEntity = TodoEntity(UUID.fromString("09d9e708-e8fc-11eb-9a03-0242ac130003"),"segunda","correr",false)
    }

    @Test
    fun `teste salvar na base de dados`(){
        every { cqlSession.execute("") } answers {resultSet}
        val result = repo.saveCql(todoEntity)
        result shouldBe Unit
    }

    @Test
    fun `teste atualizar na base de dados`(){
        every { cqlSession.execute("") } answers {resultSet}
        val result = repo.updateCql(todoEntity.id!!,todoEntity)
        result shouldBe Unit
    }

    @Test
    fun `teste deletar na base de dados`(){
        every { cqlSession.execute("") } answers {resultSet}
        val result = repo.deleteCql(todoEntity.id!!)
        result shouldBe Unit
    }

}