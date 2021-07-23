package com.example.datepicker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.datepicker.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.etDate.setOnClickListener { showDatePickerDialog() }
    }

    private fun showDatePickerDialog() {
        //funcion que ejecute el datepicker (creado en el datepickerFragment)
        val datePicker = DatePickerFragment{day, month, year -> onDateSelected(day, month, year) }
        datePicker.show(supportFragmentManager, "datePicker")
    }

     fun onDateSelected(day:Int, month:Int, year:Int){
        binding.etDate.setText("Has seleccionado el día $day del mes $month de $year")
     }
}