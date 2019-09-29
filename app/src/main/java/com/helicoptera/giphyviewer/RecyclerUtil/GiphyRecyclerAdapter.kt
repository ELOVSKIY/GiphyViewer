package com.helicoptera.giphyviewer.RecyclerUtil

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.helicoptera.giphyviewer.R
import com.helicoptera.mainview.NetWorking.Data.Data
import com.helicoptera.mainview.NetWorking.Data.GiphyResponse
import com.squareup.picasso.Picasso
import pl.droidsonroids.gif.GifImageView

class GiphyRecyclerAdapter(gifInfo: GiphyResponse?): RecyclerView.Adapter<GiphyRecyclerAdapter.ViewHolder>() {
    var gifInfoList: GiphyResponse? = gifInfo

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val cv = LayoutInflater.from(viewGroup.context).inflate(
            R.layout.waterfall_element, viewGroup, false) as CardView
        return ViewHolder(cv)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bind(
           gifInfoList!!.data[position])
    }

    override fun getItemCount(): Int {
        return gifInfoList?.data?.size ?: 0
    }

    inner class ViewHolder constructor(private val cardView: CardView) : RecyclerView.ViewHolder(cardView) {
        private val gifHolder: GifImageView = cardView.findViewById(R.id.gif_image)
        fun bind(data: Data) {
            Picasso.get()
                .load(data.images.fixedWidth.url)
                .noFade()
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.placeholder)
                .into(gifHolder)
            gifHolder.animate()
        }

    }
}