package br.com.exemplo.unittools

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.*
import kotlin.Double as Doublel

class ConversorSom : AppCompatActivity() {

    var unidades = arrayOf("Bel (B)", "Decibel (dB)", "Neper (Np)")
    var selecao = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conversor_som)

        //Carregar os componentes
        val spinner = findViewById<Spinner>(R.id.selectSom)
        val txtResultado = findViewById<TextView>(R.id.txtResultado)
        val txtValor = findViewById<EditText>(R.id.txtValor)
        val btnCalcular = findViewById<Button>(R.id.btnConverterSom)

        //Cria array adapter
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, unidades)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) { }

            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                  selecao = position
            }
        }

        btnCalcular.setOnClickListener {
            val valor = txtValor.text.toString()
            if(valor !=""){
                if(selecao == 0) {
                    var texto = "Decibel = "
                    texto += Double.parseDouble(valor) * 10f
                    texto += " dB \nNeper = "
                    texto += Double.parseDouble(valor) * 1.1512925465f
                    texto += " Np"
                    txtResultado.text = texto
                } else if (selecao == 1) {
                    var texto = "Bel = "
                    texto += Double.parseDouble(valor) / 10
                    texto += " B \nNeper = "
                    texto += Double.parseDouble(valor) / 8.685889638042575f
                    texto += " Np"
                    txtResultado.text = texto
                } else if (selecao == 2) {
                    var texto = "Bel = "
                    texto += Double.parseDouble(valor) * 0.8685889638042575f
                    texto += " B \nDecibel = "
                    texto += Double.parseDouble(valor) * 8.685889638042575f
                    texto += " dB"
                    txtResultado.text = texto
                }
            } else {
                txtResultado.text = "Adicione um valor para ser convertido."
            }
         }

        // Ativar o "up navigation" na ActionBar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    //Ativando o botão de voltar nativo do Android
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item?.itemId == android.R.id.home){
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

}