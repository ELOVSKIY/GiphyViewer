package com.helicoptera.giphyviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.helicoptera.giphyviewer.ui.main.MainViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        val viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

}
