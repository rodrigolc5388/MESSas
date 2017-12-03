package com.example.rodrigo.messas.fragments

import android.app.Activity
import android.app.Fragment
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.example.rodrigo.messas.R
import com.example.rodrigo.messas.model.Plate

class PlateDetailFragment: Fragment() {

    companion object {

        private val EXTRA_PLATE_FRAGMENT = "EXTRA_PLATE_FRAGMENT"

        fun newInstance(plate: Plate): PlateDetailFragment{
            val fragment = PlateDetailFragment()
            val arguments = Bundle()
            arguments.putSerializable(EXTRA_PLATE_FRAGMENT, plate)
            fragment.arguments = arguments

            return fragment
        }
    }


    lateinit var root: View
    private var onSetResultListener: OnSetResultListener? = null


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        super.onCreateView(inflater, container, savedInstanceState)

        inflater?.let{
            root = it.inflate(R.layout.fragment_plate_detail, container, false)

            val plate = arguments.getSerializable(EXTRA_PLATE_FRAGMENT) as Plate

            val photo = root.findViewById<ImageView>(R.id.plate_photo)
            val addButton = root.findViewById<Button>(R.id.add_plate_button)
            val glutenIcon = root.findViewById<ImageView>(R.id.gluten_icon)
            val fishIcon = root.findViewById<ImageView>(R.id.fish_icon)
            val eggIcon = root.findViewById<ImageView>(R.id.egg_icon)
            val milkIcon = root.findViewById<ImageView>(R.id.milk_icon)
            val peanutIcon = root.findViewById<ImageView>(R.id.peanut_icon)
            val requests = root.findViewById<EditText>(R.id.plate_requests_text)

            photo.setImageResource(plate.image)

            // Sett imágenes íconos alérgenos
            // Juanjo, SEGURO que debe haber una forma más elegante de hacer esto,
            // pero no se me ocurrió ninguna ¯\_(ツ)_/¯
            for (allergenIndex in 0..plate.allergens.size-1){
                val allergen = plate.allergens.get(allergenIndex)

                when(allergen.name){
                    "egg" -> {
                        if(allergen.exists == true){
                            eggIcon.setImageResource(R.drawable.egg_yes)
                        } else {eggIcon.setImageResource(R.drawable.egg_no)
                        }
                    }

                    "fish" -> {
                        if(allergen.exists == true){
                            fishIcon.setImageResource(R.drawable.fish_yes)
                        } else {fishIcon.setImageResource(R.drawable.fish_no)
                        }
                    }

                    "gluten" -> {
                        if(allergen.exists == true){
                            glutenIcon.setImageResource(R.drawable.gluten_yes)
                        } else {glutenIcon.setImageResource(R.drawable.gluten_no)
                        }
                    }

                    "milk" -> {
                        if(allergen.exists == true){
                            milkIcon.setImageResource(R.drawable.milk_yes)
                        } else {milkIcon.setImageResource(R.drawable.milk_no)
                        }
                    }

                    "peanut" -> {
                        if(allergen.exists == true){
                            peanutIcon.setImageResource(R.drawable.peanut_yes)
                        } else {peanutIcon.setImageResource(R.drawable.peanut_no)
                        }
                    }
                    //else ->
                }

                /*if(allergen.name == "egg"){
                    if(allergen.exists == true){
                        eggIcon.setImageResource(R.drawable.egg_yes)
                    } else {eggIcon.setImageResource(R.drawable.egg_no)
                    }
                }

                if(allergen.name == "fish"){
                    if(allergen.exists == true){
                        fishIcon.setImageResource(R.drawable.fish_yes)
                    } else {fishIcon.setImageResource(R.drawable.fish_no)
                    }
                }

                if(allergen.name == "gluten"){
                    if(allergen.exists == true){
                        glutenIcon.setImageResource(R.drawable.gluten_yes)
                    } else {glutenIcon.setImageResource(R.drawable.gluten_no)
                    }
                }

                if(allergen.name == "milk"){
                    if(allergen.exists == true){
                        milkIcon.setImageResource(R.drawable.milk_yes)
                    } else {milkIcon.setImageResource(R.drawable.milk_no)
                    }
                }

                if(allergen.name == "peanut"){
                    if(allergen.exists == true){
                        peanutIcon.setImageResource(R.drawable.peanut_yes)
                    } else {peanutIcon.setImageResource(R.drawable.peanut_no)
                    }
                }*/
            }

            requests.setText(plate.requests)
            requests.setOnEditorActionListener() { v, actionId, event ->
                if(actionId == EditorInfo.IME_ACTION_DONE){
                    val text = requests.text.toString()
                    plate.requests = text
                    requests.setText(plate.requests)
                    true
                }
                false
            }


            addButton.text = getString(R.string.add_button_text, plate.price)
            addButton.setOnClickListener {
                onSetResultListener?.onSetResult(plate)
            }
        }
        return root
    }


    override fun onAttach(context: Context?) {
        super.onAttach(context)
        commonAttach(context)
    }

    override fun onAttach(activity: Activity?) {
        super.onAttach(activity)
        commonAttach(activity)
    }

    override fun onDetach() {
        super.onDetach()
        onSetResultListener = null
    }

    fun commonAttach(listener: Any?) {
        if (listener is OnSetResultListener) {
            onSetResultListener = listener
        }
    }

    interface OnSetResultListener{
        fun onSetResult(plate: Plate)
    }
}