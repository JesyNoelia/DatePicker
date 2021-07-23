package com.example.datepicker

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Context
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.widget.DatePicker
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment

class DatePickerFragment(val listener: (day:Int, month:Int, year:Int) -> Unit): DialogFragment(), DatePickerDialog.OnDateSetListener {

    //el parametro de esta funcion sera una funcion, y tendra 3 parametos, dia mes y año
    //esta clase que extiende del dialogfragment, es una clase interna de android que permite es mostrar los dialogos con lo que vamos a trabajar.
    //onDate, avisa cuando seleccionamos una fecha en el calendario


    //DIALOGO QUE TIENE QUE VER EL USUARIO CON LA FECHA

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        //Cuando el usuario pulsa, se tiene que mostrar un calendario y lo mas normal es que se inicie con la fecha actual, hay una clase ya de android que da esa informacion

        val c:Calendar = Calendar.getInstance()
        val day = c.get(Calendar.DAY_OF_MONTH)
        val month = c.get(Calendar.MONTH)
        val year = c.get(Calendar.YEAR)

        //INSTANCIA DE CALENDARIO
        //una vez que se le pasa el contexto hay que pasarle el listener que se tiene que llamar cuando un usuario seleccione una fecha, se pone this por que ya esta implementado el metodo en la clase. luego se le pasa el año mes y dia
        val picker = DatePickerDialog(activity as Context, R.style.datePickerTheme, this, year, month, day )

        //LIMITAR LA FECHA POR EJEMPO PARA QUE NO SE PEUDAN SELECCIONAR FECHAS ANTIGUAS.
        picker.datePicker.minDate= c.timeInMillis
        return picker
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
       //este metodo, que sobreescribe al original y devuelve la vista del datepicker y deuelve el dia mes y año, los 3 parametros que necesitamos
        listener(dayOfMonth, month, year)
    }

}