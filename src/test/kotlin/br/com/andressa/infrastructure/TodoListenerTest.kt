package br.com.andressa.infrastructure

import br.com.andressa.core.model.Todo
import br.com.andressa.core.ports.TodoServicePort
import br.com.andressa.infrastructure.model.Events
import br.com.andressa.infrastructure.model.EventsInformation
import br.com.andressa.infrastructure.model.TodoEvent
import br.com.andressa.infrastructure.subscriber.TodoListener
import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import io.micronaut.test.extensions.kotest.annotation.MicronautTest
import io.mockk.every
import io.mockk.mockk
import java.util.*

@MicronautTest
class TodoListenerTest: AnnotationSpec() {

    val service = mockk<TodoServicePort>()
    val listener = TodoListener(service)

    lateinit var eventsInformation: EventsInformation
    lateinit var todoEvent: TodoEvent
    lateinit var todo: Todo

    @BeforeEach
    fun setUp(){
        todo = Todo(UUID.fromString("09d9e708-e8fc-11eb-9a03-0242ac130003"),"segunda","correr",false)
        todoEvent = TodoEvent(UUID.fromString("09d9e708-e8fc-11eb-9a03-0242ac130003"),"segunda","correr",false)
        eventsInformation = EventsInformation(Events.SAVE,todoEvent)
    }

    @Test
    fun `recebendo events e salvando na core`(){
        every { service.addTodo(todo) } answers {Unit}
        val result = listener.receber(eventsInformation)
        result shouldBe Unit
    }

    @Test
    fun `recebendo events e atualizando na core`(){
        every { service.updateTodo(any(),todo) } answers {Unit}
        val result = listener.receber(eventsInformation)
        result shouldBe Unit
    }

    @Test
    fun `recebendo events e deletando na core`(){
        every { service.deleteTodo(todo.id!!) } answers {Unit}
        val result = listener.receber(eventsInformation)
        result shouldBe Unit
    }
}