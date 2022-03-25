package com.lasteyestudio.smiles

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.chaquo.python.Python
import com.chaquo.python.android.AndroidPlatform

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart: started")
        val test = findViewById<TextView>(R.id.test)
        if(!Python.isStarted()){

            Log.d(TAG, "python working")
            Python.start(AndroidPlatform(this))

            val py = Python.getInstance()
            val mod = py.getModule("myclass")
            val obj = mod.callAttr("test")
            Log.d(TAG, "done")
            test.text = obj.toString()
        }
    }
}