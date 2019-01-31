package com.example.asn1shoppingapp

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_food_items.*

class FoodItemsSelector : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_items)
        btnApple.setOnClickListener {
            selectFood(btnApple.text.toString())
        }
        btnBanana.setOnClickListener {
            selectFood(btnBanana.text.toString())
        }
        btnBrocoli.setOnClickListener {
            selectFood(btnBrocoli.text.toString())
        }
        btnCeleri.setOnClickListener {
            selectFood(btnCeleri.text.toString())
        }
        btnChicken.setOnClickListener {
            selectFood(btnChicken.text.toString())
        }
        btnHam.setOnClickListener {
            selectFood(btnHam.text.toString())
        }
        btnHamburg.setOnClickListener {
            selectFood(btnHamburg.text.toString())
        }
        btnRice.setOnClickListener {
            selectFood(btnRice.text.toString())
        }
        btnCancel.setOnClickListener {
            selectFood("none")
        }
    }
    fun selectFood(sFood:String){
        val reply = sFood
        val replyIntent = Intent()
        replyIntent.putExtra("SelectedFood", reply)
        setResult(Activity.RESULT_OK,replyIntent)
        finish()
    }
}
