package com.example.rodrigo.messas.activity

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.example.rodrigo.messas.R
import com.example.rodrigo.messas.model.Plate
import java.io.Serializable

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
        val allergens = plate.allergens

        supportActionBar?.title = plate.name.capitalize()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        // Evito que el teclado aparezca automáticamente
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN)

        val name = findViewById<TextView>(R.id.plate_name)
        val photo = findViewById<ImageView>(R.id.plate_photo)
        val addButton = findViewById<Button>(R.id.add_plate_button)
        val glutenIcon = findViewById<ImageView>(R.id.gluten_icon)
        val fishIcon = findViewById<ImageView>(R.id.fish_icon)
        val eggIcon = findViewById<ImageView>(R.id.egg_icon)
        val milkIcon = findViewById<ImageView>(R.id.milk_icon)
        val peanutIcon = findViewById<ImageView>(R.id.peanut_icon)
        val requests = findViewById<EditText>(R.id.plate_requests_text)


        name.text = plate.name.capitalize()
        photo.setImageResource(plate.image)

        for (allergenIndex in 0..allergens.size-1){
            val allergen = allergens.get(allergenIndex)

            if(allergen.name == "egg" && allergen.exists == true){
                eggIcon.setImageResource(R.drawable.egg_yes)
            } else {
                eggIcon.setImageResource(R.drawable.egg_no)
            }

            if(allergen.name == "fish" && allergen.exists == true){
                fishIcon.setImageResource(R.drawable.fish_yes)
            } else {
                fishIcon.setImageResource(R.drawable.fish_no)
            }

            if(allergen.name == "gluten" && allergen.exists == true){
                glutenIcon.setImageResource(R.drawable.gluten_yes)
            } else {
                glutenIcon.setImageResource(R.drawable.gluten_no)
            }

            if(allergen.name == "milk" && allergen.exists == true){
                milkIcon.setImageResource(R.drawable.milk_yes)
            } else {
                milkIcon.setImageResource(R.drawable.milk_no)
            }

            if(allergen.name == "peanut" && allergen.exists == true){
                peanutIcon.setImageResource(R.drawable.peanut_yes)
            } else {
                peanutIcon.setImageResource(R.drawable.peanut_no)
            }
        }


        addButton.text = getString(R.string.add_button_text, plate.price)
        addButton.setOnClickListener {
            val intent = Intent()
            intent.putExtra("EXTRA_PLATE_RESULT", plate as Serializable)
            setResult(Activity.RESULT_OK, intent)
            finish()
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


