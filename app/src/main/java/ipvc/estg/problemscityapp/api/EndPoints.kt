package ipvc.estg.problemscityapp.api

import retrofit2.Call
import retrofit2.http.*

interface EndPoints {

    @GET("users/")
    fun getAllUsers(): Call<List<User>>

    @GET("users/{name}")
    fun getUserByName(@Path("name") name: String): Call<User>
}