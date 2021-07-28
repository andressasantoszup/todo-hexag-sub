package br.com.andressa.database.entity

import io.micronaut.core.annotation.Introspected
import java.util.*

@Introspected
data class TodoEntity (

    val id: UUID? = null,
    val date: String? = "",
    val description: String? ="",
    val done: Boolean = false
)