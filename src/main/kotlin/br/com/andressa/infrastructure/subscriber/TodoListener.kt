package br.com.andressa.infrastructure.subscriber

import br.com.andressa.core.mappers.TodoConverter
import br.com.andressa.core.ports.TodoServicePort
import br.com.andressa.infrastructure.model.EventsInformation
import io.micronaut.nats.annotation.NatsListener
import io.micronaut.nats.annotation.Subject
import org.slf4j.LoggerFactory


@NatsListener
class TodoListener(private val todoServicePort: TodoServicePort) {

    val log = LoggerFactory.getLogger(this::class.java)

    @Subject("todo.scheduled")
    fun receber(eventsInformation: EventsInformation){
        log.info("chegou")
//        val todo = TodoConverter.todoEventToTodo(eventsInformation.todoEvent)
//
//        when(eventsInformation.events.name){
//            "SAVE" -> todoServicePort.addTodo(todo)
//            "UPDATE" -> todoServicePort.updateTodo(todo.id!!, todo)
//            "DELETE" -> todoServicePort.deleteTodo(todo.id!!)
//        }

    }
}