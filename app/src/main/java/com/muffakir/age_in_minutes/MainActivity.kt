package com.muffakir.age_in_minutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.DatePicker
import android.widget.Toast
import com.muffakir.age_in_minutes.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.time.Year
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.dateSelect.setOnClickListener {
            clickdatepicker()

        }
    }

     fun clickdatepicker() {
         val mycalendar = Calendar.getInstance()
         val year = mycalendar.get(Calendar.YEAR)
         val month = mycalendar.get(Calendar.MONTH)
         val day = mycalendar.get(Calendar.DAY_OF_MONTH)
         val dpd = DatePickerDialog(
             this,
             { view, year, month, day
                 ->
                 val selecteddate = "$day/${month+1}/$year"
                 binding.selectedDob.text = selecteddate
                 Toast.makeText(this,"Year Was $year month was $month Day was $day",Toast.LENGTH_SHORT).show()

                 val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

                 val theDate = sdf.parse(selecteddate)
                 val selectedDateInMinutes = theDate.time / 60000
                 val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

                 val currentDateInMinutes = currentDate.time/60000

                 val differenceinMinutes =   currentDateInMinutes - selectedDateInMinutes

                 binding.AgeInMinutes.text = differenceinMinutes.toString()

             },
             year,
             month,
             day
         )
            dpd.datePicker.maxDate = System.currentTimeMillis() - 86400000
         dpd.show()
     }
}


