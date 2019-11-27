package com.example.kviz.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.kviz.model.Kviz
import com.example.kviz.R
import kotlinx.android.synthetic.main.activity_main.*

class PocetniActivity : AppCompatActivity() {

    //KONSTANTE
    val NEXT: Int = 1;
    val PREVIOUS: Int = -1
    //VARIABLE
    var kviz = Kviz()
    var trenutniIndexPitanja = 0
    var rezultat: Int = 0
    var trenutnoPitanje = kviz.pitanja[0]

    //FUNKCIJE
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //TextViews
        textViewPitanja.text = trenutnoPitanje.textPitanja
        textView_brojPitanja.text = "Pitanje: ${trenutniIndexPitanja + 1}/${kviz.pitanja.size}"
        textView_rezultat.text = "Rezultat $rezultat"

        button_dalje.isEnabled = true
        button_nazad.isEnabled = false
        button_kraj.isEnabled = false

        //Buttons
        button_da.setOnClickListener {
            odgovori(true)
        }

        button_ne.setOnClickListener {
            odgovori(false)
        }

        button_dalje.setOnClickListener {
            updateIndex(NEXT)
        }

        button_nazad.setOnClickListener {
            updateIndex(PREVIOUS)
        }

        button_kraj.setOnClickListener {
            val intent = Intent(this, KrajActivity::class.java)
            intent.putExtra(KrajActivity.REZULTAT, rezultat)
            startActivity(intent)
        }
    }

    private fun odgovori(odgovor: Boolean) {
        trenutnoPitanje.daLiJeOdgovoreno = true
        if (trenutnoPitanje.daLiJeTacno == odgovor) {
            Toast.makeText(this, "Vas odgovor je tacan", Toast.LENGTH_SHORT).show()
            rezultat += 10
            textView_rezultat.text = "Rezultat $rezultat"
        } else {
            Toast.makeText(this, "Vas odgovor je netacan", Toast.LENGTH_SHORT).show()
            rezultat -= 5
            textView_rezultat.text = "Rezultat $rezultat"
        }
        updateDaNe()
    }

    fun updateIndex(index: Int){

        if(index == NEXT){
            trenutniIndexPitanja += 1
        }else if (index == PREVIOUS){
            trenutniIndexPitanja -= 1
        }
        //AKO SMO NA PRVOM PITANJU
        if(trenutniIndexPitanja == 0){
            button_dalje.isEnabled = true
            button_nazad.isEnabled = false
            button_kraj.isEnabled = false
        }
        //AKO SMO NA ZADNJEM PITANJU
        else if(trenutniIndexPitanja == kviz.pitanja.size-1){
            button_dalje.isEnabled = false
            button_nazad.isEnabled = true
            button_kraj.isEnabled = true
        }else{
            button_dalje.isEnabled = true
            button_nazad.isEnabled = true
            button_kraj.isEnabled = false
        }
        trenutnoPitanje = kviz.pitanja[trenutniIndexPitanja]
        textViewPitanja.text = trenutnoPitanje.textPitanja
        textView_brojPitanja.text = "Pitanje: ${trenutniIndexPitanja+1}/${kviz.pitanja.size}"

        updateDaNe()
    }

    private fun updateDaNe(){
        if(trenutnoPitanje.daLiJeOdgovoreno){
            button_da.isEnabled = false
            button_ne.isEnabled = false
        }else{
            button_da.isEnabled = true
            button_ne.isEnabled = true
        }
    }
}
