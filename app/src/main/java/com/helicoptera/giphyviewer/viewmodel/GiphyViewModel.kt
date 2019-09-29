package com.helicoptera.giphyviewer.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.helicoptera.giphyviewer.NetWorking.RetrofitSingleton
import com.helicoptera.mainview.NetWorking.Data.GiphyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GiphyViewModel : ViewModel() {
    val info = MutableLiveData<GiphyResponse>()

    fun onQueryChange(query: String){
        RetrofitSingleton.getInstance().api.getGifImages(query = query).enqueue(object:
            Callback<GiphyResponse> {
            override fun onResponse(call: Call<GiphyResponse>, response: Response<GiphyResponse>) {

            }

            override fun onFailure(call: Call<GiphyResponse>, t: Throwable) {
            }
        })
    }

}
