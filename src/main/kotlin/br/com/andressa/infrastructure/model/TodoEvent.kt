package br.com.andressa.infrastructure.model

import java.util.*

class TodoEvent (

    val id: UUID? = null,
    val date: String? = "",
    val description: String? ="",
    val done: Boolean = false

)