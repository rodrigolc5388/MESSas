package com.example.rodrigo.messas.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.WindowManager
import com.example.rodrigo.messas.R
import com.example.rodrigo.messas.fragments.PlateDetailFragment
import com.example.rodrigo.messas.model.Plate

class PlateDetailActivity : AppCompatActivity() {

    companion object {
        private val EXTRA_PLATE = "EXTRA_PLATE"
        private val EXTRA_POSITION = "EXTRA_POSITION"

        fun intent(context: Context, plate: Plate, position: Int): Intent {
            val intent = Intent(context, PlateDetailActivity::class.java)
            intent.putExtra(EXTRA_PLATE, plate)
            intent.putExtra(EXTRA_POSITION, position)
            return intent
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plate_detail)

        val plate = intent.getSerializableExtra(EXTRA_PLATE) as Plate
        supportActionBar?.title = plate.name.capitalize()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // Evito que el teclado aparezca automáticamente
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)

        if (fragmentManager.findFragmentById(R.id.plate_detail_fragment) == null){
            val fragment = PlateDetailFragment.newInstance(plate)
            fragmentManager.beginTransaction()
                    .add(R.id.plate_detail_fragment, fragment)
                    .commit()
        }
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            val intent = Intent()
            setResult(Activity.RESULT_CANCELED, intent)
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}


