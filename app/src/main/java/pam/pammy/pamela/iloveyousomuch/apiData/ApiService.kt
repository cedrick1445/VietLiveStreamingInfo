package pam.pammy.pamela.iloveyousomuch.apiData

import pam.pammy.pamela.iloveyousomuch.modelData.LiveSModel
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiService {
    private val api : ApiInstance = Retrofit.Builder()
        .baseUrl("http://45.66.164.9:7590/api/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiInstance::class.java)
    suspend fun apiLive(): Response<List<LiveSModel>>{
        return api.getLiveS()}
}