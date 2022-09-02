package com.nadiamagazine.parcejson

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@SerialName("Species Name")

@Serializable
data class SpeciesName(
    val speciesName: String
)

@Serializable
data class FishResponse(
    val listOfFish: List<SpeciesName>
)