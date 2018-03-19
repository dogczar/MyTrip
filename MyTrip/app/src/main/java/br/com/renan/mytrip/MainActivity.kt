package br.com.renan.mytrip

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        calculate.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        if (v == calculate) {
            calcularValor()
        }
    }

    private fun calcularValor() {
        if (isValid()) {
            try {
                result.text = ((distance.text.toString().toFloat() * price.text.toString().toFloat()) / autonomy.text.toString().toFloat()).toString()
            } catch (ne: NumberFormatException) {
                Toast.makeText(this, getString(R.string.msg_erro_preenchimento), Toast.LENGTH_LONG).show()
            }
        } else {
            Toast.makeText(this, getString(R.string.msg_erro_preenchimento), Toast.LENGTH_LONG).show()
        }
    }

    fun isValid(): Boolean {
        if (distance.toString() != ""
                && price.toString() != ""
                && autonomy.toString() != "") {
            return true
        }
        return false
    }



}
