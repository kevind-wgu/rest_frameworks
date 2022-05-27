package com.example.plugins

import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.request.*

fun Application.configureRouting() {

    routing {
        get("/") {
//            call.respondText("Hello World!")
            call.respond(Body());
        }
        post("/customer") {
            val customer = call.receive<Customer>()
            call.respond(HttpStatusCode.Created, customer)
        }
    }
}

class Body(val v1: String = "HI");

data class Customer(val id: Int, val firstName: String?, val lastName: String)