package com.example.homeworkdialogs

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AppCompatButton
import androidx.core.content.ContextCompat
import com.google.android.material.textview.MaterialTextView
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        showAlertDialog()
        chooseAnItem()
        chooseAnDay()

    }

    private fun chooseAnDay() {
        val dialogchoose: AppCompatButton = findViewById(R.id.chooseday)
        val listOfItems = arrayOf(
            "Every day",
            "Sun",
            "Mon",
            "Tue",
            "Wed",
            "Thu",
            "Fri",
            "Sat",
        )
        val falses = booleanArrayOf(false, false, false, false, false, false, false, false)
        dialogchoose.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("Choose Day!")
                setPositiveButton("Confrim") { light, _ ->
                    light.dismiss()
                }
                setMultiChoiceItems(listOfItems, falses) { _, _, _ ->

                }
                setNegativeButton("Cancel") { blabla, _ ->
                    blabla.dismiss()
                }
            }.create().show()
        }
    }

    private fun chooseAnItem() {
        val textChangeBtn: AppCompatButton = findViewById(R.id.changetextbtn)
        val changeTextView: MaterialTextView = findViewById(R.id.textchanger)
        val listOfItems = arrayOf(
            "Onion",
            "Sausage",
            "Milk",
            "Garlic",
            "Beef",
            "Veggies",
            "Olive",
            "Cheese",
            "Tuna",
            "Mushrooms"
        )
        textChangeBtn.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("Choose Something!")
                setSingleChoiceItems(listOfItems, -1) { listing, which ->
                    listing.dismiss()
                    changeTextView.text = listOfItems[which]
                    changeTextView.setTextColor(randomColor())
                }
            }.create().show()
        }
    }

    private fun showAlertDialog() {
        val showbutton: AppCompatButton = findViewById(R.id.alertbtn)
        showbutton.setOnClickListener {
            AlertDialog.Builder(this).apply {
                setTitle("Alert Dialog instance")
                setMessage("Hello world, this is first word of every program,and very programmer write them\nDo you want to exit?")
                setNeutralButton("Can't say!") { dialog, _ ->
                    dialog.dismiss()
                }
                setPositiveButton("Yes") { _, _ ->
                    finish()
                }
                setNegativeButton("No") { dialog2, _ ->
                    dialog2.dismiss()
                }
            }.create().show()
        }
    }

    private fun randomColor(): Int {
        val random = Random()
        return Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256))
    }

//    @ColorRes
//    private fun randomColor(): Int {
//        val list = listOf(
//            R.color.red,
//            R.color.blue,
//            R.color.green
//        )
//        val random = (list.indices).random()
//        return list[random]
//    }
}