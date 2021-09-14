package pam.pammy.pamela.iloveyousomuch.apiData

import pam.pammy.pamela.iloveyousomuch.modelData.LiveSModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiInstance {
    @GET("livestreamapi")
    suspend fun getLiveS (): Response<List<LiveSModel>>
}