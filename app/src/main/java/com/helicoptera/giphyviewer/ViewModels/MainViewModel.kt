package com.helicoptera.giphyviewer.ViewModels

import android.content.Context
import android.net.ConnectivityManager
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    fun hasNetConnection(context: Context): Boolean{
        val cm = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = cm.activeNetworkInfo
        if (netInfo != null && netInfo.isConnectedOrConnecting())
        {
            return true
        }
        return false

    }

}
