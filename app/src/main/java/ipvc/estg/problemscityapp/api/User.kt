package ipvc.estg.problemscityapp.api

data class User(
    val id: Int,
    val name: String,
    val email: String,
    val password: String,
    val adress: String
)