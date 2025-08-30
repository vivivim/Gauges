package com.example.gauges.model

data class Gauge(
    val id: String = "",
    val title: String = "",
    val yarn: String = "",
    val needle: Double = 0.0,

    val stitches: Double = 0.0,
    val rows: Double = 0.0,

    val width: Double = 0.0,
    val height: Double = 0.0,

    val type: Type = Type.STOCKING
)

enum class Type{
    STOCKING, PATTERN
}