package com.example.testnav

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

class MainActivity : AppCompatActivity() {
    val viewModel: ItemViewModel by viewModels()
    var isNewOp = true
    var text = ""
    var oldNum = 0.0
    var newNum = 0.0
    var op = ""
    var result = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setUpFragment()
    }

    private fun setUpFragment() {
        val mFragment = supportFragmentManager
        val fragmentTransaction = mFragment.beginTransaction()
        val resFrag = ResFragment()
        val keyFrag = KeyboardFragment()
        fragmentTransaction.add(R.id.flRes, resFrag, null)
        fragmentTransaction.add(R.id.flKeyBoard, keyFrag, null)
        fragmentTransaction.commit()
    }

    fun onClickNumber(view: View) {
        if (isNewOp) {
            text = ""
        }
        isNewOp = false
        if (view is Button) {
            text += view.text

        }
        viewModel.setData(text)
    }

    fun onClickOp(view: View) {
        isNewOp = true
        if (view is Button) {
            oldNum = text.toDouble()
            text = view.text.toString()
            op = view.text.toString()
        }
        viewModel.setData(text)
    }

    fun equalEvent(view: View) {
        if (view is Button) {
            newNum = text.toDouble()
            result = when (op) {
                "+" -> oldNum + newNum
                "-" -> oldNum - newNum
                "*" -> oldNum * newNum
                "/" -> oldNum / newNum
                else -> result
            }

        }
        viewModel.setData(result.toString())
    }

    fun onClickCE(view: View) {
        if (view is Button) {
            text = ""
            oldNum = 0.0
            newNum = 0.0
            result = 0.0
        }

        viewModel.setData(text)
    }
}