package com.example.asn1shoppingapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ListView
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    val FOOD_REQUEST = 1

    val LOG_TAG = MainActivity::class.java.simpleName
    companion object ItemList {
        var items = ArrayList<Food>()
        var new = true
        fun addItem(inName: String){
            if(inName!="none"){
                for (fItem in items){
                    if (fItem.name == inName){
                        fItem.quantity++
                        new =false
                    }
                }
                if (new){
                    items.add( Food(inName, 1))
                }
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val listView = findViewById<ListView>(R.id.main_lstItems)
        listView.adapter = BaseAdapter(this)

        if (savedInstanceState != null && savedInstanceState.containsKey("Items")) {
            items = savedInstanceState.getParcelableArrayList<Food>("Items")
        }
        btnAddItem.setOnClickListener{
            launchList()
        }
    }

    private fun launchList() {
        val intent = Intent(this, FoodItemsSelector::class.java)
        startActivityForResult(intent, FOOD_REQUEST )
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        Log.d(LOG_TAG,"onSaveInstanceState")
        outState?.putParcelableArrayList("Items", items)
    }

    public override fun onActivityResult( requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == FOOD_REQUEST) {
            if (resultCode == RESULT_OK) {
                Log.d(LOG_TAG,"got that food !!!")
                val food = data?.getStringExtra("SelectedFood").toString().toUpperCase()
                addItem(food)
                val listView = findViewById<ListView>(R.id.main_lstItems)
                listView.adapter = BaseAdapter(this)
            }
        }
    }
}
