package br.com.andressa.infrastructure.subscriber

import io.micronaut.nats.annotation.NatsListener
import io.micronaut.nats.annotation.Subject


@NatsListener
class TodoListener {

    @Subject()
    fun receber(){

    }
}