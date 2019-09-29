package com.helicoptera.giphyviewer.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import com.helicoptera.giphyviewer.R
import com.helicoptera.giphyviewer.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {
    lateinit var viewmodel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        viewmodel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        setSupportActionBar(toolbar)
    }

    override fun onResume() {
        super.onResume()
        setUpFragment()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_toolbar_menu, menu)
        val searchView = menu?.findItem(R.id.action_search)?.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                setUpFragment()
                putDataIntoFragment(query)
                return true
            }

            override fun onQueryTextChange(query: String?): Boolean {
                setUpFragment()
                putDataIntoFragment(query)
                return true
            }
        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_setting -> {
                val intent = Intent(this, SettingActivity::class.java)
                startActivity(intent)
            }
        }
        return true
    }

    private fun putDataIntoFragment(query: String?){
        val id = Navigation.findNavController(this, R.id.nav_host_fragment)
            .currentDestination!!.id
        var fragment = supportFragmentManager.findFragmentById(id)
        if (fragment is GiphyFragment){
            fragment.onChangeQuery(query)
        }
    }

    private fun setUpFragment(){
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        if (viewmodel.hasNetConnection(this)){
            navController.navigate(R.id.giphyFragment)
        }else{
            navController.navigate(R.id.disconnectFragment)
        }

    }
}
