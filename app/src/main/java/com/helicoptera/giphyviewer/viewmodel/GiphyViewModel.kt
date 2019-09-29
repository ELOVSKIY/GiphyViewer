package com.helicoptera.giphyviewer.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.helicoptera.giphyviewer.NetWorking.RetrofitSingleton
import com.helicoptera.giphyviewer.NetWorking.hasNetConnection
import com.helicoptera.mainview.NetWorking.Data.GiphyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GiphyViewModel : ViewModel() {
    val liveResponse = MutableLiveData<GiphyResponse>()

    fun onQueryChange(query: String, context: Context?) {
        if (hasNetConnection(context)) {
            RetrofitSingleton.getInstance().api.getGifImages(query = query).enqueue(object :
                Callback<GiphyResponse> {
                override fun onResponse(
                    call: Call<GiphyResponse>,
                    response: Response<GiphyResponse>
                ) {
                    liveResponse.value = response.body()
                }

                override fun onFailure(call: Call<GiphyResponse>, t: Throwable) {
                    throw t
                }
            })
        }
    }

}
