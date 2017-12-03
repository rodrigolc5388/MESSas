package com.example.rodrigo.messas.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.MenuItem
import android.view.View
import com.example.rodrigo.messas.R
import com.example.rodrigo.messas.adapter.PlatesRecyclerViewAdapter
import com.example.rodrigo.messas.fragments.PlatesFragment
import com.example.rodrigo.messas.fragments.TableFragment
import com.example.rodrigo.messas.model.Plate
import com.example.rodrigo.messas.model.Plates
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.coroutines.experimental.bg

class PlatesActivity : AppCompatActivity() {

    companion object {

        fun intent(context: Context): Intent {
            val intent = Intent(context, PlatesActivity::class.java)
            return intent
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plates)

        supportActionBar?.title = getString(R.string.plates_activity_title)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        if(fragmentManager.findFragmentById(R.id.plates_fragment) == null){
            val fragment = PlatesFragment.newInstance()
            fragmentManager.beginTransaction()
                    .add(R.id.plates_fragment, fragment)
                    .commit()
        }
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
