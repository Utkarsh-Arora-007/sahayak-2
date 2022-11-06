package com.google.mlkit.vision.demo.dataclass

data class RestroItem(
    val Description: String = "",
    val Image: String = "",
    val Location: String = "",
    val Name: String = "",
    val Price: Double = 0.0,
    val Rating: Double = 0.0,
    val id: Int = 0
)