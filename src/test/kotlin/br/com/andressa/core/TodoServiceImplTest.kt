package br.com.andressa.core

import br.com.andressa.core.model.Todo
import br.com.andressa.core.ports.TodoRepositoryPort
import br.com.andressa.core.service.TodoServiceImpl
import br.com.andressa.database.entity.TodoEntity
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.util.*

@MicronautTest
class TodoServiceImplTest: AnnotationSpec() {

    val repo = mockk<TodoRepositoryPort>()
    val service = TodoServiceImpl(repo)

    lateinit var todoEntity: TodoEntity
    lateinit var todo: Todo

    @BeforeEach
    fun setUp(){
        todoEntity = TodoEntity(UUID.fromString("09d9e708-e8fc-11eb-9a03-0242ac130003"),"segunda","correr",false)
        todo = Todo(UUID.fromString("09d9e708-e8fc-11eb-9a03-0242ac130003"),"segunda","correr",false)
    }

    @Test
    fun `obj chegando na core e indo para infra`(){
        every { repo.saveCql(todoEntity) } answers {Unit}
        val result = service.addTodo(todo)
        result shouldBe Unit
    }

    @Test
    fun `obj chegando na core e atualizando na infra`(){
        every { repo.updateCql(any(),todoEntity) } answers {Unit}
        val result = service.updateTodo(UUID.fromString("09d9e708-e8fc-11eb-9a03-0242ac130003"),todo)
        result shouldBe Unit
    }

    @Test
    fun `obj chegando na core e deletando na infra`(){
     every { repo.deleteCql(any()) } answers  {Unit}
     val result = service.deleteTodo(UUID.fromString("09d9e708-e8fc-11eb-9a03-0242ac130003"))
        result shouldBe Unit
    }
}