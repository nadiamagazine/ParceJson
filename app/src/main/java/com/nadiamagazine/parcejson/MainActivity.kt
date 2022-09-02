package com.nadiamagazine.parcejson

import android.os.Bundle
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.nadiamagazine.parcejson.viewmodel.VM
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private val viewModel: VM by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val text = findViewById<TextView>(R.id.show_name)

        lifecycleScope.launch {
            val name = viewModel.getSpeciesName()
            text.text = name.listOfFish
        }
    }
}