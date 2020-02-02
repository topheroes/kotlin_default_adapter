package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class OurData(var selected:String?="", var glasses:String?=""):Parcelable{
    var textList = listOf("Serage", "Danya", "Maxx")

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(selected)
        parcel.writeString(glasses)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<OurData> {
        override fun createFromParcel(parcel: Parcel): OurData {
            return OurData(parcel)
        }

        override fun newArray(size: Int): Array<OurData?> {
            return arrayOfNulls(size)
        }
    }


}

const val EXTRA_DATA = "data"
const val TAG_INFO = "info"

class MainActivity : AppCompatActivity() {

    lateinit var dataClass:OurData

    override fun onCreate(savedInstanceState: Bundle?) {

        dataClass = OurData()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun seregaClicked(view : View){

        dataClass.selected = "serega"
        seregaBtn.isChecked = true
        danyaBtn.isChecked = false
        maxxBtn.isChecked = false
    }

    fun danyaClicked(view : View){
        dataClass.selected = "danya"
        seregaBtn.isChecked = false
        danyaBtn.isChecked = true
        maxxBtn.isChecked = false

    }

    fun maxxClicked(view : View){
        dataClass.selected = "maxx"
        seregaBtn.isChecked = false
        danyaBtn.isChecked = false
        maxxBtn.isChecked = true

    }

    fun gotoGlassActivity(view: View){
        if (dataClass.selected != "") {
            val glassIntent = Intent(this, glasses_activity::class.java)
            glassIntent.putExtra(EXTRA_DATA, dataClass)
            startActivity(glassIntent)
        }else{
            Log.i(TAG_INFO, "none selected")
        }
    }
}
