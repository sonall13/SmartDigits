package com.example.smartdigits

import android.os.Bundle
import android.util.TypedValue
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var b1: Button
    private lateinit var b2: Button
    private lateinit var b3: Button
    private lateinit var b4: Button
    private lateinit var b5: Button
    private lateinit var b6: Button
    private lateinit var b7: Button
    private lateinit var b8: Button
    private lateinit var b9: Button
    private lateinit var b0: Button
    private lateinit var b_equal: Button
    private lateinit var b_multi: Button
    private lateinit var b_divide: Button
    private lateinit var b_add: Button
    private lateinit var b_sub: Button
    private lateinit var b_clear: Button
    private lateinit var b_dot: Button
    private lateinit var b_para1: Button
    private lateinit var b_para2: Button
    private lateinit var t1: TextView
    private lateinit var t2: TextView
    private val ADDITION = '+'
    private val SUBTRACTION = '-'
    private val MULTIPLICATION = '*'
    private val DIVISION = '/'
    private val EQU = '='
    private val EXTRA = '@'
    private val MODULUS = '%'
    private var ACTION = 0.toChar()
    private var val1 = Double.NaN
    private var val2 = 0.0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewSetup()

        b1.setOnClickListener {
            ifErrorOnOutput()
            exceedLength()
            t1.text = t1.text.toString() + "1"
        }

        b2.setOnClickListener {
            ifErrorOnOutput()
            exceedLength()
            t1.text = t1.text.toString() + "2"
        }

        b3.setOnClickListener {
            ifErrorOnOutput()
            exceedLength()
            t1.text = t1.text.toString() + "3"
        }

        b4.setOnClickListener {
            ifErrorOnOutput()
            exceedLength()
            t1.text = t1.text.toString() + "4"
        }

        b5.setOnClickListener {
            ifErrorOnOutput()
            exceedLength()
            t1.text = t1.text.toString() + "5"
        }

        b6.setOnClickListener {
            ifErrorOnOutput()
            exceedLength()
            t1.text = t1.text.toString() + "6"
        }

        b7.setOnClickListener {
            ifErrorOnOutput()
            exceedLength()
            t1.text = t1.text.toString() + "7"
        }

        b8.setOnClickListener {
            ifErrorOnOutput()
            exceedLength()
            t1.text = t1.text.toString() + "8"
        }

        b9.setOnClickListener {
            ifErrorOnOutput()
            exceedLength()
            t1.text = t1.text.toString() + "9"
        }

        b0.setOnClickListener {
            ifErrorOnOutput()
            exceedLength()
            t1.text = t1.text.toString() + "0"
        }

        b_dot.setOnClickListener {
            exceedLength()
            t1.text = t1.text.toString() + "."
        }

        b_para1.setOnClickListener {
            if (t1.text.isNotEmpty()) {
                ACTION = MODULUS
                operation()
                if (!ifReallyDecimal()) {
                    t2.text = "$val1%"
                } else {
                    t2.text = val1.toInt().toString() + "%"
                }
                t1.text = null
            } else {
                t2.text = "Error"
            }
        }


        b_add.setOnClickListener {
            if (t1.text.isNotEmpty()) {
                ACTION = ADDITION
                operation()
                if (!ifReallyDecimal()) {
                    t2.text = "$val1+"
                } else {
                    t2.text = val1.toInt().toString() + "+"
                }
                t1.text = null
            } else {
                t2.text = "Error"
            }
        }


        b_sub.setOnClickListener {
            if (t1.text.isNotEmpty()) {
                ACTION = SUBTRACTION
                operation()
                if (t1.text.isNotEmpty()) if (!ifReallyDecimal()) {
                    t2.text = "$val1-"
                } else {
                    t2.text = val1.toInt().toString() + "-"
                }
                t1.text = null
            } else {
                t2.text = "Error"
            }
        }


        b_multi.setOnClickListener {
            if (t1.text.isNotEmpty()) {
                ACTION = MULTIPLICATION
                operation()
                if (!ifReallyDecimal()) {
                    t2.text = "$val1×"
                } else {
                    t2.text = val1.toInt().toString() + "×"
                }
                t1.text = null
            } else {
                t2.text = "Error"
            }
        }


        b_divide.setOnClickListener {
            if (t1.text.isNotEmpty()) {
                ACTION = DIVISION
                operation()
                if (ifReallyDecimal()) {
                    t2.text = val1.toInt().toString() + "/"
                } else {
                    t2.text = "$val1/"
                }
                t1.text = null
            } else {
                t2.text = "Error"
            }
        }


        b_para2.setOnClickListener {
            if (t2.text.toString().isNotEmpty() || t1.text.toString().isNotEmpty()) {
                val1 = t1.text.toString().toDouble()
                ACTION = EXTRA
                t2.text = "-" + t1.text.toString()
                t1.text = ""
            } else {
                t2.text = "Error"
            }
        }


        b_equal.setOnClickListener {
            if (t1.text.isNotEmpty()) {
                operation()
                ACTION = EQU
                if (!ifReallyDecimal()) {
                    t2.text = val1.toString()
                } else {
                    t2.text = val1.toInt().toString()
                }
                t1.text = null
            } else {
                t2.text = "Error"
            }
        }


        b_clear.setOnClickListener {
            if (t1.text.isNotEmpty()) {
                val name: CharSequence = t1.text.toString()
                t1.text = name.subSequence(0, name.length - 1)
            } else {
                val1 = Double.NaN
                val2 = Double.NaN
                t1.text = ""
                t2.text = ""
            }
        }


        // Empty text views on long click.
        b_clear.setOnLongClickListener {
            val1 = Double.NaN
            val2 = Double.NaN
            t1.text = ""
            t2.text = ""
            true
        }
    }

    private fun viewSetup() {

        b1 = findViewById(R.id.button1)
        b2 = findViewById(R.id.button2)
        b3 = findViewById(R.id.button3)
        b4 = findViewById(R.id.button4)
        b5 = findViewById(R.id.button5)
        b6 = findViewById(R.id.button6)
        b7 = findViewById(R.id.button7)
        b8 = findViewById(R.id.button8)
        b9 = findViewById(R.id.button9)
        b0 = findViewById(R.id.button0)
        b_equal = findViewById(R.id.button_equal)
        b_multi = findViewById(R.id.button_multi)
        b_divide = findViewById(R.id.button_divide)
        b_add = findViewById(R.id.button_add)
        b_sub = findViewById(R.id.button_sub)
        b_clear = findViewById(R.id.button_clear)
        b_dot = findViewById(R.id.button_dot)
        b_para1 = findViewById(R.id.button_para1)
        b_para2 = findViewById(R.id.button_para2)
        t1 = findViewById(R.id.input)
        t2 = findViewById(R.id.output)

    }

    private fun operation() {
        if (!java.lang.Double.isNaN(val1)) {

            if (t2.text.toString()[0] == '-') {
                val1 *= -1
            }

            val2 = t1.text.toString().toDouble()

            when (ACTION) {
                ADDITION -> val1 += val2
                SUBTRACTION -> val1 -= val2
                MULTIPLICATION -> val1 *= val2
                DIVISION -> val1 /= val2
                EXTRA -> val1 *= -1
                MODULUS -> val1 %= val2
                EQU -> {}
            }
        }
        else {
            val1 = t1.text.toString().toDouble()
        }

    }

    // Remove error message that is already written there.
    private fun ifErrorOnOutput() {
        if (t2.text.toString() == "Error") {
            t2.text = ""
        }
    }

    // Whether value if a double or not
    private fun ifReallyDecimal(): Boolean {
        return val1 == val1.toInt().toDouble()
    }

    private fun noOperation() {
        var inputExpression = t2.text.toString()
        if (inputExpression.isNotEmpty() && inputExpression != "Error") {
            if (inputExpression.contains("-")) {
                inputExpression = inputExpression.replace("-", "")
                t2.text = ""
                val1 = inputExpression.toDouble()
            }
            if (inputExpression.contains("+")) {
                inputExpression = inputExpression.replace("+", "")
                t2.text = ""
                val1 = inputExpression.toDouble()
            }
            if (inputExpression.contains("/")) {
                inputExpression = inputExpression.replace("/", "")
                t2.text = ""
                val1 = inputExpression.toDouble()
            }
            if (inputExpression.contains("%")) {
                inputExpression = inputExpression.replace("%", "")
                t2.text = ""
                val1 = inputExpression.toDouble()
            }
            if (inputExpression.contains("×")) {
                inputExpression = inputExpression.replace("×", "")
                t2.text = ""
                val1 = inputExpression.toDouble()
            }
        }
    }

    // Make text small if too many digits.
    private fun exceedLength() {
        if (t1.text.toString().length > 10) {
            t1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20f)
        }
    }
}