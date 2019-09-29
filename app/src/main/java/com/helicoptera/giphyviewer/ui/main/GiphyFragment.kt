package com.helicoptera.giphyviewer.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.SearchView
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.helicoptera.giphyviewer.R
import com.helicoptera.giphyviewer.RecyclerUtil.GiphyRecyclerAdapter
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
        val recyclerView =
            inflater.inflate(R.layout.giphy_fragment, container, false) as RecyclerView
        val recyclerAdapter = GiphyRecyclerAdapter(null)
        val layoutManager = LinearLayoutManager(context)

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = recyclerAdapter

        viewModel = ViewModelProviders.of(this).get(GiphyViewModel::class.java)

        viewModel.liveResponse.observe(this, Observer {
            recyclerAdapter.gifInfoList = it
            recyclerAdapter.notifyDataSetChanged()
        })
        return recyclerView
    }

    override fun onResume() {
        onChangeQuery("")
        super.onResume()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        val searchView = menu?.findItem(R.id.action_search)?.actionView
        if (searchView is SearchView) {
            searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    onChangeQuery(query)
                    return true
                }
                override fun onQueryTextChange(query: String?): Boolean {
                    onChangeQuery(query)
                    return true
                }
            })
        }
        super.onCreateOptionsMenu(menu, inflater)
    }


    fun onChangeQuery(query: String?) {
        var modQuery = query ?: "popular"
        modQuery = if (modQuery == "") "popular" else modQuery
        viewModel.onQueryChange(modQuery, context)
    }


}
