package com.nadiamagazine.parcejson

import io.ktor.client.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*


suspend fun getSpeciesName(): FishResponse {

    val client = HttpClient {
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

    val response: FishResponse = client
        .get("https://www.fishwatch.gov/api/species")
    client.close()
    return response
}

