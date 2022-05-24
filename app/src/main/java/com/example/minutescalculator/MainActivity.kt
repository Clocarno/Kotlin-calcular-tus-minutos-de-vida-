package com.example.minutescalculator

import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.util.*

class MainActivity : AppCompatActivity() {

    var textFecha:TextView? = null
    var textResult:TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btnDatePicker: Button = findViewById(R.id.btnDatePicker)

        val formatter = SimpleDateFormat("dd/MM/yyyy")
        val currentDate = formatter.format(System.currentTimeMillis())
        textFecha = findViewById(R.id.txtFecha)
        textResult = findViewById(R.id.txtTotalMinute)
        textFecha?.text = currentDate.toString()

        btnDatePicker.setOnClickListener {

            Toast.makeText(this, " Esto es un mensaje", Toast.LENGTH_SHORT).show()
            val myCalendar = Calendar.getInstance()
            val year = myCalendar.get(Calendar.YEAR)
            val month = myCalendar.get(Calendar.MONTH)
            val day = myCalendar.get(Calendar.DAY_OF_MONTH)

            DatePickerDialog(
                this, DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->

                    val fecha:String = "$dayOfMonth/${month + 1}/$year"
                    Toast.makeText(this, "La fecha que escojistes es $fecha", Toast.LENGTH_SHORT).show()
                    textFecha?.text = fecha

                    val formatter = SimpleDateFormat("dd/MM/yyyy")
                    val dateChoosed = formatter.parse(fecha)
                    val currentDate = formatter.parse( formatter.format(System.currentTimeMillis()))
                    val dateDifference = (currentDate.time - dateChoosed.time)/60000
                    textResult?.text = "Tienes un total de   ${dateDifference.toString()} minutos de haber nacido"

                },
                year, month, day
            ).show()
        }


    }
}