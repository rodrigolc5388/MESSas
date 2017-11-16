package com.example.rodrigo.messas.activity

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.example.rodrigo.messas.R
import com.example.rodrigo.messas.model.Plate

class PlateDetailActivity : AppCompatActivity() {

    companion object {
        private val EXTRA_PLATE = "EXTRA_PLATE"

        fun intent(context: Context, plate: Plate): Intent {
            val intent = Intent(context, PlateDetailActivity::class.java)
            intent.putExtra(EXTRA_PLATE, plate)
            return intent
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_plate_detail)

        supportActionBar?.title = "Macarrones"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

//        val plate = intent.getSerializableExtra(EXTRA_PLATE) as Plate

//        if (plate != null) {

            val name = findViewById<TextView>(R.id.plate_name)
            val photo = findViewById<ImageView>(R.id.plate_photo)
            val glutenIcon = findViewById<ImageView>(R.id.gluten_icon)
            val fishIcon = findViewById<ImageView>(R.id.fish_icon)
            val eggIcon = findViewById<ImageView>(R.id.egg_icon)
            val milkIcon = findViewById<ImageView>(R.id.milk_icon)
            val peanutIcon = findViewById<ImageView>(R.id.peanut_icon)
            val requests = findViewById<EditText>(R.id.plate_requests_text)
            val addButton = findViewById<Button>(R.id.add_plate_button)

            photo.setImageResource(R.drawable.macarrones)
            name.text = "Macarrones"
            //glutenIcon.setImageResource(plate.allergens[position].icon)
            //fishIcon.setImageResource(plate.allergens[position].icon)
            //eggIcon.setImageResource(plate.allergens[position].icon)
            //milkIcon.setImageResource(plate.allergens[position].icon)
            //peanutIcon.setImageResource(plate.allergens[position].icon)
            //val buttonText = getString(R.string.add_button_text, plate.price)
            //addButton.text = buttonText
            addButton.text = "Agregar: 15€"
//        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item?.itemId == android.R.id.home) {
            // Sabemos que se ha pulsado la flecha de 'back'
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}


