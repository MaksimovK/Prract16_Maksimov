package com.example.prract16

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import android.graphics.Rect
import android.icu.util.Calendar
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.*
import java.text.SimpleDateFormat

class CreateAlarmActivity : AppCompatActivity() {
    private lateinit var Time: TextView
    private lateinit var Data: TextView
    private lateinit var saveButton: Button
    private lateinit var deleteButton: Button
    private lateinit var checkBox1: CheckBox
    private lateinit var checkBox2: CheckBox
    private lateinit var checkBox3: CheckBox
    private lateinit var checkBox4: CheckBox
    private lateinit var checkBox5: CheckBox
    private lateinit var checkBox6: CheckBox
    private lateinit var checkBox7: CheckBox
    private lateinit var backButton: ImageButton
    lateinit var scrollView1: ScrollView
    lateinit var scrollView2: ScrollView
    var selectedText: TextView? = null
    var selectedText2: TextView? = null
    var isCheckBoxEnabled: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_alarm)
        Time = findViewById(R.id.time)
        Data = findViewById(R.id.data)

        scrollView1 = findViewById<ScrollView>(R.id.ScrollView_Time)
        scrollView2 = findViewById<ScrollView>(R.id.ScrollView_Data)

        saveButton = findViewById(R.id.button_addTask)
        deleteButton = findViewById(R.id.button_removeTask)
        backButton = findViewById(R.id.back_button)

        checkBox1 = findViewById(R.id.checkbox1)
        checkBox2 = findViewById(R.id.checkbox2)
        checkBox3 = findViewById(R.id.checkbox3)
        checkBox4 = findViewById(R.id.checkbox4)
        checkBox5 = findViewById(R.id.checkbox5)
        checkBox6 = findViewById(R.id.checkbox6)
        checkBox7 = findViewById(R.id.checkbox7)


        val checkBoxes = listOf(checkBox1, checkBox2, checkBox3, checkBox4, checkBox5, checkBox6, checkBox7)
        val messages = listOf(
            "Понедельник",
            "Вторник",
            "Среда",
            "Четверг",
            "Пятница",
            "Суббота",
            "Воскресенье"
        )
        isCheckBoxEnabled = true
        checkBoxes.forEachIndexed { index, checkBox ->
            checkBox.setOnCheckedChangeListener { buttonView, isChecked ->
                if (isChecked) {
                    val text = "${messages[index]} - ${selectedText?.text}/${selectedText2?.text}"
                    Toast.makeText(applicationContext, text, Toast.LENGTH_SHORT).show()

                    val prevIndex = index - 1
                    val nextIndex = index + 1
                    val prevCheckBox = checkBoxes.getOrNull(prevIndex)
                    val nextCheckBox = checkBoxes.getOrNull(nextIndex)

                    if (prevCheckBox?.isChecked == true) {
                        prevCheckBox.isChecked = false
                    }

                    if (nextCheckBox?.isChecked == true) {
                        nextCheckBox.isChecked = false
                    }
                }
            }
        }
        saveButton.setOnClickListener { view: View ->
            var i = Toast.makeText(this, "Будильник добавлен", Toast.LENGTH_SHORT)
            i.setGravity(Gravity.BOTTOM, 0, 0)
            i.show()
            checkBoxes.forEach { checkBox ->
                checkBox.isEnabled = false
            }
        }
        deleteButton.setOnClickListener { view: View ->
            var i = Toast.makeText(this, "Будильник удалён", Toast.LENGTH_SHORT)
            i.setGravity(Gravity.BOTTOM, 0, 0)
            i.show()
            checkBoxes.forEach { checkBox ->
                checkBox.isEnabled = true
                checkBox.isChecked = false
            }
        }

        Time.setOnClickListener {
            val cal = Calendar.getInstance()
            val timeSetListener = TimePickerDialog.OnTimeSetListener { timePicker, hour, minute ->
                cal.set(Calendar.HOUR_OF_DAY, hour)
                cal.set(Calendar.MINUTE, minute)
                Time.text = SimpleDateFormat("HH:mm").format(cal.time)
            }
            TimePickerDialog(
                this,
                timeSetListener,
                cal.get(Calendar.HOUR_OF_DAY),
                cal.get(Calendar.MINUTE),
                true
            ).show()
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
        backButton.setOnClickListener {
            val intent = Intent(this, ProfileActivity::class.java)
            startActivity(intent)
        }
    }
}