package com.example.rodrigo.messas.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import com.example.rodrigo.messas.R
import com.example.rodrigo.messas.fragments.PlatesFragment
import com.example.rodrigo.messas.model.Plate

class PlatesActivity : AppCompatActivity(), PlatesFragment.OnSelectedPlateListener {

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

    override fun onSelectedPlate(plate: Plate, position: Int) {
        val intent = PlateDetailActivity.intent(this, plate, position)
        intent.addFlags(Intent.FLAG_ACTIVITY_FORWARD_RESULT)
        startActivity(intent)
    }
}
