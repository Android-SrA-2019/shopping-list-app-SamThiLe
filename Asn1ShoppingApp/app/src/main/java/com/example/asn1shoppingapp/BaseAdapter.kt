package com.example.asn1shoppingapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class BaseAdapter( context: Context) : BaseAdapter(){
    private val mContext: Context = context

    //renders each row
    override fun getView(position: Int, convertView: View?, viewGroup: ViewGroup?): View {
        val layoutInflater = LayoutInflater.from(mContext)
        val rowMAin = layoutInflater.inflate(R.layout.row_main, viewGroup , false)
        val txtCount = rowMAin.findViewById<TextView>(R.id.txtCount)
        val txtName = rowMAin.findViewById<TextView>(R.id.txtName)
        txtCount.text = MainActivity.items[position].quantity.toString()
        txtName.text = MainActivity.items[position].name
        return rowMAin
    }

    override fun getItem(position: Int): Any {
        return "String"
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
    //how may rows will be displayed
    override fun getCount(): Int {
        return MainActivity.items.size
    }
}