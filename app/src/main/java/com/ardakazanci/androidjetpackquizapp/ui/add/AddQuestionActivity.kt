/*
 * *
 *  * Created by Arda Kazancı on 7/9/19 6:52 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 7/9/19 6:52 PM
 *
 */

package com.ardakazanci.androidjetpackquizapp.ui.add

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.core.view.get
import androidx.lifecycle.ViewModelProviders
import com.ardakazanci.androidjetpackquizapp.R
import com.ardakazanci.androidjetpackquizapp.model.Question
import kotlinx.android.synthetic.main.activity_add_question.*

class AddQuestionActivity : AppCompatActivity() {

    private lateinit var viewModel: AddQuestionViewModel
    private lateinit var answer: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_question)

        viewModel = ViewModelProviders.of(this).get(AddQuestionViewModel::class.java)

        prepareSpinner()

        button_save.setOnClickListener {

            val question = edt_question.text.toString()
            val option_a = edt_option_a.text.toString()
            val option_b = edt_option_b.text.toString()
            val option_c = edt_option_c.text.toString()


            viewModel.insert(
                Question(
                    question = question,
                    optionA = option_a,
                    optionB = option_b,
                    optionC = option_c,
                    answer = if (answer == "A") option_a else if (answer == "B") option_b else option_c

                )
            )

            Toast.makeText(this, "Soru Ekleme Başalarılı", Toast.LENGTH_LONG).show()

        }

    }

    private fun prepareSpinner() {

        val optList = mutableListOf("A", "B", "C")
        val adapter = ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item, optList)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                answer = p0?.getItemAtPosition(p2).toString()

            }

        }

    }


}
