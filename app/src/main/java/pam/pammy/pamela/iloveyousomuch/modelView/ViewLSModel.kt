package pam.pammy.pamela.iloveyousomuch.modelView

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import pam.pammy.pamela.iloveyousomuch.apiData.ApiService
import pam.pammy.pamela.iloveyousomuch.modelData.LiveSModel

class ViewLSModel : ViewModel() {

    private val apiService = ApiService()
    private var liveList = ArrayList<LiveSModel>()

    private val liveData = MutableLiveData<List<LiveSModel>>()
    val live : LiveData<List<LiveSModel>> get() = liveData

    private val errorApi = CoroutineExceptionHandler{ _, _ ->
        liveData.postValue(null) }

    fun homeW(): MutableLiveData<List<LiveSModel>>{
        liveList.clear()
        viewModelScope.launch ( errorApi + Dispatchers.IO ){
            val response = apiService.apiLive().body()!!
            for(dataH in response){
                if (dataH.subtitle == "home"){
                    liveList.add(dataH)
                    liveData.postValue(liveList)
                }}}
        return liveData }

    fun stepW(): MutableLiveData<List<LiveSModel>>{
        liveList.clear()
        viewModelScope.launch( errorApi + Dispatchers.IO ){
            val response = apiService.apiLive().body()!!
            for(dataS in response){
                if(dataS.subtitle == "steps"){
                    liveList.add(dataS)
                    liveData.postValue(liveList)
                }}}
        return liveData}

    fun riskW(): MutableLiveData<List<LiveSModel>>{
        liveList.clear()
        viewModelScope.launch( errorApi + Dispatchers.IO ){
            val response = apiService.apiLive().body()!!
            for(dataS in response){
                if(dataS.subtitle == "risk"){
                    liveList.add(dataS)
                    liveData.postValue(liveList)
                }}}
        return liveData }

    fun featW(): MutableLiveData<List<LiveSModel>>{
        liveList.clear()
        viewModelScope.launch( errorApi + Dispatchers.IO ){
            val response = apiService.apiLive().body()!!
            for(dataS in response){
                if(dataS.subtitle == "features"){
                    liveList.add(dataS)
                    liveData.postValue(liveList)
                }}}
        return liveData}
}