package com.helicoptera.giphyviewer.ui.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.SearchView
import androidx.navigation.Navigation
import com.helicoptera.giphyviewer.Utils.hasNetConnection
import com.helicoptera.giphyviewer.R
import kotlinx.android.synthetic.main.main_activity.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        setSupportActionBar(toolbar)
    }

    override fun onResume() {
        super.onResume()
        setUpFragment()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_toolbar_menu, menu)
        val searchView = menu?.findItem(R.id.action_search)?.actionView as SearchView
        searchView.setOnCloseListener {
            setUpFragment()
            true
        }
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


    private fun setUpFragment(){
        val navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        if (hasNetConnection(this)){
            navController.navigate(R.id.giphyFragment)
        }else{
            navController.navigate(R.id.disconnectFragment)
        }

    }
}
