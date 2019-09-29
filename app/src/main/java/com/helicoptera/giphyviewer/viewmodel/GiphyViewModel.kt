package com.helicoptera.giphyviewer.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.helicoptera.giphyviewer.NetWorking.RetrofitSingleton
import com.helicoptera.giphyviewer.Utils.LanguageUtil
import com.helicoptera.giphyviewer.Utils.hasNetConnection
import com.helicoptera.giphyviewer.Utils.PrefUtil
import com.helicoptera.mainview.NetWorking.Data.GiphyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GiphyViewModel : ViewModel() {
    val liveResponse = MutableLiveData<GiphyResponse>()


    fun onQueryChange(query: String, context: Context?) {
        if (hasNetConnection(context)) {
            val rating = if (PrefUtil.getGifRating(context)) "r" else "pg-13"

            val languageCode = PrefUtil.getGifLang(context)
            val language = LanguageUtil.getLanguageCode(languageCode)
            RetrofitSingleton.getInstance().api.getGifImages(
                query = query, rating = rating, lang = language)
                .enqueue(object :
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
