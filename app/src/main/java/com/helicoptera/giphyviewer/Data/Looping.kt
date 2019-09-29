package com.helicoptera.mainview.NetWorking.Data


import com.google.gson.annotations.SerializedName

data class Looping(
    val mp4: String,
    @SerializedName("mp4_size")
    val mp4Size: String
)