package com.example.prract16

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.icu.util.Calendar
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.*
import java.text.SimpleDateFormat


class EditTaskActivity : AppCompatActivity() {
    private lateinit var BackButton: ImageButton
    private lateinit var EditButton: Button
    private lateinit var NameTask: EditText
    private lateinit var Time: TextView
    private lateinit var Data: TextView
    private lateinit var Info: EditText
    private lateinit var RemoveTask: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_task)
        BackButton = findViewById(R.id.back_button)
        NameTask = findViewById(R.id.NameAlarm)
        Time = findViewById(R.id.time)
        Data = findViewById(R.id.data)
        Info = findViewById(R.id.info)
        EditButton = findViewById(R.id.button_addTask)
        RemoveTask = findViewById(R.id.button_removeTask)

        Time.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                Time.text = SimpleDateFormat("HH:mm").format(cal.time)
            }
            TimePickerDialog(this, timeSetListener, cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), true).show()
        }
        Data.setOnClickListener {

            val cal = Calendar.getInstance()
            val dateSetListener = DatePickerDialog.OnDateSetListener { datePicker, i, i2, i3 ->
                cal.set(Calendar.DAY_OF_MONTH, i)
                cal.set(Calendar.MONTH, i2)
                cal.set(Calendar.YEAR, i3)
                Data.text = "${i3 + 1}-${i2 + 1}-${i}"
            }
            DatePickerDialog(
                this,
                dateSetListener,
                cal.get(Calendar.DAY_OF_MONTH),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.YEAR)
            ).show()
        }


        BackButton.setOnClickListener {
            val intent = Intent(this, CreateAlarmActivity::class.java)
            startActivity(intent)
        }
        EditButton.setOnClickListener {
            if (NameTask.text.toString().isEmpty() || Time.text.toString().isEmpty() || Data.text.toString().isEmpty() || Info.text.toString().isEmpty()) {
                val toast = Toast.makeText(this, R.string.CheckEditText, Toast.LENGTH_SHORT)
                toast.setGravity(Gravity.BOTTOM, 0, 0)
                toast.show()


            }
            else
            {
                val toast = Toast.makeText(this, "Задача изменена", Toast.LENGTH_SHORT)
                toast.setGravity(Gravity.BOTTOM, 0, 0)
                toast.show()
            }
        }
        RemoveTask.setOnClickListener {
            NameTask.text = null
            Time.text = null
            Data.text = null
            Info.text = null
            val toast = Toast.makeText(this, "Задача удалена", Toast.LENGTH_SHORT)
            toast.setGravity(Gravity.BOTTOM, 0, 0)
            toast.show()
        }

    }
}