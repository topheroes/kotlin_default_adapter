package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_glasses_activity.*

class glasses_activity : AppCompatActivity() {

    lateinit var data:OurData



    override fun onCreate(savedInstanceState: Bundle?) {
        data = intent.getParcelableExtra<OurData>(EXTRA_DATA)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_glasses_activity)
    }

    fun choseGlasses(view:View){
        data.glasses = "glasses"
        glassesBtn.isChecked = true
        noGlassesBtn.isChecked = false
    }

    fun choseNoGlasses(view:View){
        data.glasses = "noglasses"
        glassesBtn.isChecked = false
        noGlassesBtn.isChecked = true
    }

    fun toActivity2(view : View){

        var activity2 = Intent(this, Main2Activity::class.java)
        activity2.putExtra(EXTRA_DATA, data)
        startActivity(activity2);

    }
}
