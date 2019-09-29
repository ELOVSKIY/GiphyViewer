package com.helicoptera.mainview.NetWorking.Data


import com.google.gson.annotations.SerializedName

data class Data(

    @SerializedName("bitly_gif_url")
    val bitlyGifUrl: String,

    @SerializedName("bitly_url")
    val bitlyUrl: String,

    @SerializedName("content_url")
    val contentUrl: String,

    @SerializedName("embed_url")
    val embedUrl: String,

    val images: Images,

    @SerializedName("is_sticker")
    val isSticker: Int,

    val rating: String,

    val slug: String,

    @SerializedName("source_post_url")
    val sourcePostUrl: String,

    @SerializedName("source_tld")
    val sourceTld: String,

    val title: String,

    val url: String
)