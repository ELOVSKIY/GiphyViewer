package com.helicoptera.giphyviewer.Utils

class LanguageUtil {

    companion object {
        val languages = listOf(
            "en",
            "es",
            "pt",
            "id",
            "fr",
            "ar",
            "tr",
            "th",
            "vi",
            "de",
            "it",
            "ja",
            "zh-CH",
            "zh-TW",
            "ru",
            "ko",
            "pl",
            "nl",
            "ro",
            "hu",
            "cs",
            "hi",
            "bn",
            "da",
            "fa",
            "tl",
            "fi",
            "iw",
            "ms",
            "no",
            "uk"
        )

        fun getLanguageCode(pos: Int): String {
            return languages[pos]
        }
    }

}


