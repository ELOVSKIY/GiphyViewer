package com.helicoptera.giphyviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.helicoptera.giphyviewer.Utils.PrefUtil
import kotlinx.android.synthetic.main.activity_setting.*

class SettingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        updateUI()
    }

    fun updateUI(){
        val lang = PrefUtil.getGifLang(this)
        val isAdult = PrefUtil.getGifRating(this)

        spinner.setSelection(lang)
        adultToggle.isChecked = isAdult
    }

    fun updatePref(){
        val lang = spinner.selectedItemPosition
        val isAdult = adultToggle.isChecked

        PrefUtil.setGifLang(lang, this)
        PrefUtil.setGifRating(isAdult, this)
    }

    override fun onDestroy() {
        super.onDestroy()

        updatePref()
    }


}
