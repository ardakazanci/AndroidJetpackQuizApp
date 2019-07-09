/*
 * *
 *  * Created by Arda Kazancı on 7/8/19 9:29 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 7/8/19 9:29 PM
 *
 */

package com.ardakazanci.androidjetpackquizapp.ui.start

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ardakazanci.androidjetpackquizapp.R
import com.ardakazanci.androidjetpackquizapp.ui.add.AddQuestionActivity
import com.ardakazanci.androidjetpackquizapp.ui.quiz.QuizActivity
import kotlinx.android.synthetic.main.activity_main.*


class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_start.setOnClickListener {
            startActivity(Intent(this, QuizActivity::class.java))
            finish()
        }

        button_add.setOnClickListener {

            startActivity(Intent(this, AddQuestionActivity::class.java))

        }


    }
}
