package com.helicoptera.giphyviewer.Utils

import android.content.Context
import android.preference.PreferenceManager

class PrefUtil {
    companion object{
        private const val LANGUAGE_SETTING = "com.helicoptera.language"

        fun getGifLang(context: Context): Int{
            val preference = PreferenceManager.getDefaultSharedPreferences(context)
            return preference.getInt(LANGUAGE_SETTING, 0)
        }

        fun setGifLang(lang: Int, context: Context){
            val editor
                    = PreferenceManager.getDefaultSharedPreferences(context).edit()
            editor.putInt(LANGUAGE_SETTING, lang)
            editor.apply()
        }

        private const val RATING_SETTING = "com.helicoptera.rating"

        fun getGifRating(context: Context): Boolean{
            val preference = PreferenceManager.getDefaultSharedPreferences(context)
            return preference.getBoolean(RATING_SETTING, false)
        }

        fun setGifRating(isAdult:Boolean, context: Context){
            val editor =
                PreferenceManager.getDefaultSharedPreferences(context).edit()
            editor.putBoolean(RATING_SETTING, isAdult)
            editor.apply()
        }

    }
}