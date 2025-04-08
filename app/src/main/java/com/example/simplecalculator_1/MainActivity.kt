package com.example.simplecalculator_1

import android.os.Bundle
import android.text.InputFilter
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var operation = ""

        val edt_input = findViewById<EditText>(R.id.edt_input)
        edt_input.filters = arrayOf(InputFilter.LengthFilter(15))
        edt_input.showSoftInputOnFocus = false
        edt_input.requestFocus()

        val tv_value = findViewById<TextView>(R.id.tv_value)
        tv_value.filters = arrayOf(InputFilter.LengthFilter(15))

        val btn_1 = findViewById<Button>(R.id.btn_1)
        val btn_2 = findViewById<Button>(R.id.btn_2)
        val btn_3 = findViewById<Button>(R.id.btn_3)
        val btn_4 = findViewById<Button>(R.id.btn_4)
        val btn_5 = findViewById<Button>(R.id.btn_5)
        val btn_6 = findViewById<Button>(R.id.btn_6)
        val btn_7 = findViewById<Button>(R.id.btn_7)
        val btn_8 = findViewById<Button>(R.id.btn_8)
        val btn_9 = findViewById<Button>(R.id.btn_9)
        val btn_0 = findViewById<Button>(R.id.btn_0)

        val btn_point = findViewById<Button>(R.id.btn_point)

        val btn_reset = findViewById<Button>(R.id.btn_reset)
        val btn_delete = findViewById<Button>(R.id.btn_delete)
        val btn_division = findViewById<Button>(R.id.btn_division)
        val btn_multiplication = findViewById<Button>(R.id.btn_multiplication)
        val btn_subtraction = findViewById<Button>(R.id.btn_subtraction)
        val btn_sum = findViewById<Button>(R.id.btn_sum)
        val btn_equally = findViewById<Button>(R.id.btn_equally)

//        Кнопка "СБРОС"
        btn_reset.setOnClickListener {
            edt_input.setText("")
            tv_value.setText("")
            operation = ""
        }

//        Кнопка "УДАЛЕНИЕ"
        btn_delete.setOnClickListener {
            val input = edt_input.text
            val cursorPosition = edt_input.selectionStart
            val symbol = "."

            if (input.isNotEmpty() && cursorPosition == 0) {
                return@setOnClickListener
            }

            if (input.length == 1 && input[0] in '0'..'9') {
                input.delete(cursorPosition - 1, cursorPosition)
                edt_input.setSelection(cursorPosition - 1)
                return@setOnClickListener
            }

            if (cursorPosition == 1 && input[0] in '1'..'9' && input[cursorPosition] == '0' && symbol !in input && input.length == 2) {
                input.delete(cursorPosition - 1, cursorPosition)
                edt_input.setSelection(cursorPosition - 1)
                return@setOnClickListener
            }

            if (cursorPosition == 1 && input[0] in '1'..'9' && input[cursorPosition] == '0' && input[cursorPosition + 1] == '.') {
                input.delete(cursorPosition - 1, cursorPosition)
                edt_input.setSelection(cursorPosition - 1)
                return@setOnClickListener
            }

            if(input.isNotEmpty() && cursorPosition > 0 && symbol !in input) {
                val deletedChar = input[cursorPosition - 1]
                val nextChar = if (cursorPosition < input.length - 1) input[cursorPosition] else null
                input.delete(cursorPosition - 1, cursorPosition)
                edt_input.setSelection(cursorPosition - 1)
                if (deletedChar in '1'..'9' && nextChar == '0') {
                    val cleanedNull = input.toString().trimStart('0')
                    edt_input.setText(cleanedNull)
                    edt_input.setSelection(cursorPosition - 1)
                }
            }

            if(input.isNotEmpty() && cursorPosition > 0 && symbol in input) {
                val deletedChar = input[cursorPosition - 1]
                val nextChar = if (cursorPosition < input.length - 1) input[cursorPosition] else null
                input.delete(cursorPosition - 1, cursorPosition)
                edt_input.setSelection(cursorPosition - 1)
                if (deletedChar in '1'..'9' && nextChar == '0') {
                    if (input[1] == '.') {
                        return@setOnClickListener
                    }
                    val cleanedNull = input.toString().trimStart('0')
                    edt_input.setText(cleanedNull)
                    edt_input.setSelection(cursorPosition - 1)
                }
            }

            if (input.isNotEmpty() && input.all { it == '0' }) {
                edt_input.setText("0")
                edt_input.setSelection(edt_input.text.length)
            }
        }

//        Кнопки 0-9
        btn_1.setOnClickListener {
            val input = edt_input.text
            val cursorPosition = edt_input.selectionStart

            if (input.startsWith("0") && input.length == 1) {
                edt_input.setText("1")
                edt_input.setSelection(edt_input.text.length)
                return@setOnClickListener
            }
            if (cursorPosition == 1 && input[0] == '0' && input[cursorPosition] == '.') {
                val symbol = input.replaceRange(0, 1, "1")
                edt_input.setText(symbol)
                edt_input.setSelection(cursorPosition)
                return@setOnClickListener
            }
            input.insert(cursorPosition, "1")
        }

        btn_2.setOnClickListener {
            val input = edt_input.text
            val cursorPosition = edt_input.selectionStart

            if (input.startsWith("0") && input.length == 1) {
                edt_input.setText("2")
                edt_input.setSelection(edt_input.text.length)
                return@setOnClickListener
            }
            if (cursorPosition == 1 && input[0] == '0' && input[cursorPosition] == '.') {
                val symbol = input.replaceRange(0, 1, "2")
                edt_input.setText(symbol)
                edt_input.setSelection(cursorPosition)
                return@setOnClickListener
            }
            input.insert(cursorPosition, "2")
        }

        btn_3.setOnClickListener {
            val input = edt_input.text
            val cursorPosition = edt_input.selectionStart

            if (input.startsWith("0") && input.length == 1) {
                edt_input.setText("3")
                edt_input.setSelection(edt_input.text.length)
                return@setOnClickListener
            }
            if (cursorPosition == 1 && input[0] == '0' && input[cursorPosition] == '.') {
                val symbol = input.replaceRange(0, 1, "3")
                edt_input.setText(symbol)
                edt_input.setSelection(cursorPosition)
                return@setOnClickListener
            }
            input.insert(cursorPosition, "3")
        }

        btn_4.setOnClickListener {
            val input = edt_input.text
            val cursorPosition = edt_input.selectionStart

            if (input.startsWith("0") && input.length == 1) {
                edt_input.setText("4")
                edt_input.setSelection(edt_input.text.length)
                return@setOnClickListener
            }
            if (cursorPosition == 1 && input[0] == '0' && input[cursorPosition] == '.') {
                val symbol = input.replaceRange(0, 1, "4")
                edt_input.setText(symbol)
                edt_input.setSelection(cursorPosition)
                return@setOnClickListener
            }
            input.insert(cursorPosition, "4")
        }

        btn_5.setOnClickListener {
            val input = edt_input.text
            val cursorPosition = edt_input.selectionStart

            if (input.startsWith("0") && input.length == 1) {
                edt_input.setText("5")
                edt_input.setSelection(edt_input.text.length)
                return@setOnClickListener
            }
            if (cursorPosition == 1 && input[0] == '0' && input[cursorPosition] == '.') {
                val symbol = input.replaceRange(0, 1, "5")
                edt_input.setText(symbol)
                edt_input.setSelection(cursorPosition)
                return@setOnClickListener
            }
            input.insert(cursorPosition, "5")
        }

        btn_6.setOnClickListener {
            val input = edt_input.text
            val cursorPosition = edt_input.selectionStart

            if (input.startsWith("0") && input.length == 1) {
                edt_input.setText("6")
                edt_input.setSelection(edt_input.text.length)
                return@setOnClickListener
            }
            if (cursorPosition == 1 && input[0] == '0' && input[cursorPosition] == '.') {
                val symbol = input.replaceRange(0, 1, "6")
                edt_input.setText(symbol)
                edt_input.setSelection(cursorPosition)
                return@setOnClickListener
            }
            input.insert(cursorPosition, "6")
        }

        btn_7.setOnClickListener {
            val input = edt_input.text
            val cursorPosition = edt_input.selectionStart

            if (input.startsWith("0") && input.length == 1) {
                edt_input.setText("7")
                edt_input.setSelection(edt_input.text.length)
                return@setOnClickListener
            }
            if (cursorPosition == 1 && input[0] == '0' && input[cursorPosition] == '.') {
                val symbol = input.replaceRange(0, 1, "7")
                edt_input.setText(symbol)
                edt_input.setSelection(cursorPosition)
                return@setOnClickListener
            }
            input.insert(cursorPosition, "7")
        }

        btn_8.setOnClickListener {
            val input = edt_input.text
            val cursorPosition = edt_input.selectionStart

            if (input.startsWith("0") && input.length == 1) {
                edt_input.setText("8")
                edt_input.setSelection(edt_input.text.length)
                return@setOnClickListener
            }
            if (cursorPosition == 1 && input[0] == '0' && input[cursorPosition] == '.') {
                val symbol = input.replaceRange(0, 1, "8")
                edt_input.setText(symbol)
                edt_input.setSelection(cursorPosition)
                return@setOnClickListener
            }
            input.insert(cursorPosition, "8")
        }

        btn_9.setOnClickListener {
            val input = edt_input.text
            val cursorPosition = edt_input.selectionStart

            if (input.startsWith("0") && input.length == 1) {
                edt_input.setText("9")
                edt_input.setSelection(edt_input.text.length)
                return@setOnClickListener
            }
            if (cursorPosition == 1 && input[0] == '0' && input[cursorPosition] == '.') {
                val symbol = input.replaceRange(0, 1, "9")
                edt_input.setText(symbol)
                edt_input.setSelection(cursorPosition)
                return@setOnClickListener
            }
            input.insert(cursorPosition, "9")
        }

        btn_0.setOnClickListener {
            val input = edt_input.text
            val cursorPosition = edt_input.selectionStart
            val symbol = "."

            if (input.isEmpty()) input.insert(cursorPosition, "0")
            if (input.toString() == "0") return@setOnClickListener

            if (input.isNotEmpty()) {
                if (cursorPosition == input.length) {
                    input.insert(cursorPosition, "0")
                    return@setOnClickListener
                }
                if (cursorPosition == 1 && input[0] == '0' && input[cursorPosition] == '.') {
                    return@setOnClickListener
                }
                if (cursorPosition != 0 && input[cursorPosition - 1] in '0'..'9' && symbol !in input && input[0] in '1'..'9') {
                    input.insert(cursorPosition, "0")
                    return@setOnClickListener
                }
                if (cursorPosition == 0 && input[cursorPosition] == '.' && cursorPosition < input.length) {
                    input.insert(cursorPosition, "0")
                    return@setOnClickListener
                }
                if (cursorPosition == 1 && input[cursorPosition] == '.' && input[0] in '1'..'9') {
                    input.insert(cursorPosition, "0")
                    return@setOnClickListener
                }
                if (cursorPosition == 1 && input[cursorPosition - 1] in '1'..'9' && input[cursorPosition] in '0'..'9') {
                    input.insert(cursorPosition, "0")
                    return@setOnClickListener
                }
                if (cursorPosition > 1 && input[cursorPosition - 1] in '0'..'9' && input[cursorPosition] == '.') {
                    input.insert(cursorPosition, "0")
                    return@setOnClickListener
                }
                if (cursorPosition > 1 && input[cursorPosition - 1] in '0'..'9' && input[cursorPosition] in '0'..'9') {
                    input.insert(cursorPosition, "0")
                    return@setOnClickListener
                }
                if (cursorPosition > 0 && input[cursorPosition - 1] == '.') {
                    input.insert(cursorPosition, "0")
                    return@setOnClickListener
                }
                if (cursorPosition > 0 && input[cursorPosition - 1] in '0'..'9' && symbol in input) {
                    input.insert(cursorPosition, "0")
                    return@setOnClickListener
                }
            }











        }

        btn_point.setOnClickListener {
            val input = edt_input.text
            val cursorPosition = edt_input.selectionStart
            if (input.isEmpty()) {
                edt_input.setText("0.")
                edt_input.setSelection(edt_input.text.length)
            } else input.insert(cursorPosition,".")
        }

//        Кнопка "ДЕЛЕНИЕ"
        btn_division.setOnClickListener {
            val value = tv_value.text
            var support = edt_input.text.toString()

            if (value.isNotEmpty()) {
                return@setOnClickListener
            }

            edt_input.setText("")
            tv_value.setText(support)
            operation = "division"
        }

//        Кнопка "УМНОЖЕНИЕ"
        btn_multiplication.setOnClickListener {
            val value = tv_value.text
            var support = edt_input.text.toString()

            if (value.isNotEmpty()) {
                return@setOnClickListener
            }

            edt_input.setText("")
            tv_value.setText(support)
            operation = "multiplication"
        }

//        Кнопка "ВЫЧИТАНИЕ"
        btn_subtraction.setOnClickListener {
            val value = tv_value.text
            var support = edt_input.text.toString()

            if (value.isNotEmpty()) {
                return@setOnClickListener
            }

            edt_input.setText("")
            tv_value.setText(support)
            operation = "subtraction"
        }

//        Кнопка "СЛОЖЕНИЕ"
        btn_sum.setOnClickListener {
            val value = tv_value.text
            var support = edt_input.text.toString()

            if (value.isNotEmpty()) {
                return@setOnClickListener
            }

            edt_input.setText("")
            tv_value.setText(support)
            operation = "sum"
        }

//        Кнопка "РАВНО"
        btn_equally.setOnClickListener {
            val input = edt_input.text.toString()
            val value = tv_value.text.toString()

            val input_num = input.toDoubleOrNull()
            val value_num = value.toDoubleOrNull()

            val cursorPosition = edt_input.selectionStart

            if (input.isEmpty()) {
                if (value.isNotEmpty()) {
                    edt_input.setText(value)
                    tv_value.setText("")
                    return@setOnClickListener
                }
            }

            if (input.isNotEmpty()) {
                if (value.isEmpty()) {
                    return@setOnClickListener
                }
            }

            if (input.isNotEmpty() && value.isNotEmpty()) {
                if (operation == "division") {
                    if (input_num != null && value_num != null && input_num != 0.0) {
                        val result = value_num / input_num
                        val format = if (result % 1 == 0.0) result.toInt() else result
                        var division = format.toString()
                        edt_input.setText(division)
                        edt_input.setSelection(edt_input.text.length)
                        tv_value.setText("")
                        operation = ""
                    } else {
                        Toast.makeText(this, "Нельзя делить на 0", Toast.LENGTH_SHORT).show()
                    }
                }
                if (operation == "multiplication") {
                    if (input_num != null && value_num != null) {
                        val result = value_num * input_num
                        val format = if (result % 1 == 0.0) result.toInt() else result
                        val multiplication = format.toString()
                        edt_input.setText(multiplication)
                        edt_input.setSelection(edt_input.text.length)
                        tv_value.setText("")
                        operation = ""
                    }
                }
                if (operation == "subtraction") {
                    if (input_num != null && value_num != null) {
                        val result = value_num - input_num
                        val format = if (result % 1 == 0.0) result.toInt() else result
                        val subtraction = format.toString()
                        edt_input.setText(subtraction)
                        edt_input.setSelection(edt_input.text.length)
                        tv_value.setText("")
                        operation = ""
                    }
                }
                if (operation == "sum") {
                    if (input_num != null && value_num != null) {
                        val result = value_num + input_num
                        val format = if (result % 1 == 0.0) result.toInt() else result
                        val sum = format.toString()
                        edt_input.setText(sum)
                        edt_input.setSelection(edt_input.text.length)
                        tv_value.setText("")
                        operation = ""
                    }
                }
            }
        }
    }
}