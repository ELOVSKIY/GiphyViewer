package com.helicoptera.giphyviewer.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.helicoptera.giphyviewer.R
import com.helicoptera.giphyviewer.viewmodel.GiphyViewModel


class GiphyFragment : Fragment() {

    companion object {
        fun newInstance() = GiphyFragment()
    }

    private lateinit var viewModel: GiphyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.giphy_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(GiphyViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
