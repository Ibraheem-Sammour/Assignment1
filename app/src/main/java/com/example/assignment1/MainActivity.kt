package com.example.assignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.btnCalc)
        val edtxt: EditText = findViewById(R.id.txtNum)
        val resultTV: TextView = findViewById(R.id.txtRes)

        var flag: String = "small"
        //here .. create a spinner items (options)
        val spinnerVal: Spinner = findViewById(R.id.spselect)
        var options = arrayOf("small(2$)", "medium(4$)", "large(5$)")
        spinnerVal.adapter =
            ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, options)
        button.setOnClickListener { view ->
            var x: Int = edtxt.text.toString().toInt();

            if (flag == "small(2$)")
                resultTV.text = small(x).toString();
            else if (flag == "medium(4$)")
                resultTV.text = medium(x).toString();
            else
                resultTV.text = large(x).toString();
        }

        spinnerVal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                flag = options.get(p2) //p2 is the index of selected item
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }
    }
}
    public fun small(a: Int): Int {
        return a * 2
    }

    public fun medium(a: Int): Int {
        return a * 4
    }

    public fun large(a: Int): Int {
        return a * 5
    }