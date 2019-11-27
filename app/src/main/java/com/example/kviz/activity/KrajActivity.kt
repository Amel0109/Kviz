package com.example.kviz.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kviz.R
import kotlinx.android.synthetic.main.activity_kraj.*

class KrajActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kraj)

        val rezultat = intent.getIntExtra(REZULTAT, 0)
        textView.text = "Vas rezultat je: $rezultat"
    }
    companion object{
        const val REZULTAT = "REZULTAT"
    }
}
