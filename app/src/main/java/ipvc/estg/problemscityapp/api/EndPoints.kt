package ipvc.estg.problemscityapp.api

import retrofit2.Call
import retrofit2.http.*

interface EndPoints {

    @GET("user/{name}")
    fun getUserByName(@Path("name") name: String): Call<User>

    @GET("report")
    fun getReports(): Call<List<Report>>

}