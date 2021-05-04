package ipvc.estg.problemscityapp.api

import java.util.*

data class Report (
    val id: Int,
    val title: String,
    val description: String,
    val lat: Float,
    val lng: Float,
    val date_creation: Date,
    val type: String,
    val user_id: Int
)