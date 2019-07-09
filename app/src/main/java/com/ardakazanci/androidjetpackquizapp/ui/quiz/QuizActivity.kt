/*
 * *
 *  * Created by Arda Kazancı on 7/9/19 2:31 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 7/9/19 2:31 PM
 *
 */

package com.ardakazanci.androidjetpackquizapp.ui.quiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.ardakazanci.androidjetpackquizapp.R

class QuizActivity : AppCompatActivity() {

    private lateinit var viewModel: QuizViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        viewModel = ViewModelProviders.of(this).get(QuizViewModel::class.java)

        viewModel.allQuestions.observe(this, Observer {


        })

    }
}
