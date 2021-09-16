package com.nadiamagazine.parcejson

import io.ktor.client.*
import io.ktor.client.features.DataConversion.install
import io.ktor.client.features.auth.*
import io.ktor.client.features.auth.providers.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.serialization.json.Json


suspend fun getInstitutionName(): InstitutionName {

    val client = HttpClient {
            install(Auth) {
                providers.add(
                    BasicAuthProvider(
                        credentials = {
                            BasicAuthCredentials(
                                username = "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",
                                password = "x-oauth-basic"
                            )
                        },
                        sendWithoutRequestCallback = { true }
                    )
                )
            }
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
        .get("https://raw.githubusercontent.com/Banno/grip-assets/master/institutions/5db40b7a-ee76-42b3-acb9-eb7045011c2a/properties.json")
    client.close()
    return response
}

