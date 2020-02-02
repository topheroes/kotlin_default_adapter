package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListAdapter
import android.widget.ListView

import kotlinx.android.synthetic.main.activity_main2.*


class Main2Activity : AppCompatActivity() {

    lateinit var data:OurData

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)


        data = intent.getParcelableExtra(EXTRA_DATA)

        var adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data.textList)
        myList.adapter = adapter
    }
}
