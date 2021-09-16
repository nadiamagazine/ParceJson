package com.nadiamagazine.parcejson

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*


suspend fun getInstitutionName(): InstitutionName {

    val client = HttpClient {
        // Just for an example how I would do authentication for http request
//            install(Auth) {
//                providers.add(
//                    BasicAuthProvider(
//                        credentials = {
//                            BasicAuthCredentials(
//                                username = "",
//                                password = ""
//                            )
//                        },
//                        sendWithoutRequestCallback = { true }
//                    )
//                )
//            }
        install(JsonFeature) {
            serializer = KotlinxSerializer(
                kotlinx.serialization.json.Json {
                    isLenient = true
                    ignoreUnknownKeys = true
                }
            )
            acceptContentTypes = listOf(ContentType.Application.Json, ContentType.Text.Plain)
        }
    }

    val response: InstitutionName = client
        .get("https://api.banno.com/institutions/5db40b7a-ee76-42b3-acb9-eb7045011c2a")
    client.close()
    return response
}

