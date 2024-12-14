package com.example.practica04

import android.os.Bundle
import android.os.Message
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private val sizeArray = 10
    private var currentPosition = 0

    private lateinit var motos: Array<Motocicleta?>

    // instancias de componentes graficos
    private lateinit var title: TextView
    private lateinit var message: TextView
    private lateinit var brand: EditText
    private lateinit var model: EditText
    private lateinit var price: EditText
    private lateinit var year: EditText

//    private lateinit var clean: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        motos = Array(sizeArray) { Motocicleta() }

        initComponents()
//        buttonsListeners()
    }

    private fun initComponents() {
        title = findViewById(R.id.txtTitle)
        message = findViewById(R.id.txtMessage)
        brand = findViewById(R.id.edtBrand)
        model = findViewById(R.id.edtModel)
        price = findViewById(R.id.edtPrice)
        year = findViewById(R.id.edtYear)
//        clean = findViewById(R.id.btnClean)
    }

//    private fun buttonsListeners(){
//        clean.setOnClickListener{
//            brand.setText("")
//            model.setText("")
//            price.setText("")
//            year.setText("")
//            message.setText("La vista fue limpiada :p")
//
//            Toast.makeText(this, "Vista limpia", Toast.LENGTH_LONG).show()
//        }
//    }

    fun add(view: View?) {
            if (model.text.isNotEmpty() && price.text.isNotEmpty() && year.text.isNotEmpty() && brand.text.isNotEmpty()) { //
                motos[currentPosition]!!.brand = brand.text.toString().orEmpty()
                motos[currentPosition]!!.model = model.text.toString().orEmpty()
                motos[currentPosition]!!.price = price.text.toString().toDouble()
                motos[currentPosition]!!.year = year.text.toString().toInt()

                message.setText("El modelo ${motos[currentPosition]!!.model} fue registrado con éxito! :p")
                Toast.makeText(this, "Modelo: ${motos[currentPosition]!!.model} registrado", Toast.LENGTH_LONG).show()
                currentPosition++
            } else {
                message.setText("Registra todos los datos, por favor :p")
                Toast.makeText(this, "Registrar todos los datos, por favor", Toast.LENGTH_LONG).show()
            }
        }

    fun clean(view: View?) {
        brand.setText("")
        model.setText("")
        price.setText("")
        year.setText("")
        message.setText("La vista fue limpiada :p")

        Toast.makeText(this, "Vista limpia", Toast.LENGTH_LONG).show()
    }

    fun search(view: View?) {
        var counter = 0
        if(model.text.isNotEmpty()){
            for (i in 0 until sizeArray) {
                if(motos[i]!!.model == model.text.toString()) {
                    brand.setText("${getString(R.string.brand)} ${motos[i]!!.brand}")
                    model.setText("${getString(R.string.model)} ${motos[i]!!.model}")
                    price.setText("${getString(R.string.price)} ${motos[i]!!.price.toString()}")
                    year.setText("${getString(R.string.year)} ${motos[i]!!.year.toString()}")

                    message.setText("Un objeto fue encontrado! c:")
                    Toast.makeText(this, "Objeto mostrado", Toast.LENGTH_LONG).show()
                    break
                } else {
                    counter = -1
                }
            }
        //} else if (counter == -1){
        //    message.setText("No se encontraron coincidencias :c")
        //    Toast.makeText(this, "No se encontro una motocicleta para mostrar", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Ingresa un modelo para buscar", Toast.LENGTH_LONG).show()
        }
    }
}