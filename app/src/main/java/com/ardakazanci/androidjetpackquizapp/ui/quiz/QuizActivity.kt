/*
 * *
 *  * Created by Arda Kazancı on 7/9/19 2:31 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 7/9/19 2:31 PM
 *
 */

package com.ardakazanci.androidjetpackquizapp.ui.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.ardakazanci.androidjetpackquizapp.R
import com.ardakazanci.androidjetpackquizapp.model.Question
import com.ardakazanci.androidjetpackquizapp.ui.result.ResultActivity
import com.ardakazanci.androidjetpackquizapp.util.Constants
import com.google.android.material.chip.Chip
import kotlinx.android.synthetic.main.activity_quiz.*

class QuizActivity : AppCompatActivity() {

    private lateinit var viewModel: QuizViewModel

    private var questionList: List<Question> = arrayListOf()
    private var qIndex: Int = 0
    private var score: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        viewModel = ViewModelProviders.of(this).get(QuizViewModel::class.java)

        viewModel.allQuestions.observe(this, Observer {


            if (it.isNotEmpty()) {
                questionList = it

                setViews()

                next_btn.setOnClickListener {
                    // Seçili chip ' in id ' sini alıyoruz.
                    val answer = findViewById<Chip>(chip_group.checkedChipId)
                    chip_group.clearCheck()
                    checkAnswer(answer)
                    qIndex++


                    // Listenin sonuna geldiğinde , son elemana gelip gelmediğinin kontrolü yapılmalı.
                    if (qIndex < questionList.size) {
                        setViews()
                    } else {
                        //Toast.makeText(this,"Score = ${score}",Toast.LENGTH_LONG).show()
                        val intent = Intent(this, ResultActivity::class.java)
                        intent.putExtra(Constants.EXTRA_RESULT, score)
                        intent.putExtra(Constants.EXTRA_LIST_SIZE, questionList.size)
                        startActivity(intent)
                        finish() // Geri Dönülmesini engellemek için.
                    }


                }
            }


        })

    }

    private fun checkAnswer(answer: Chip) {

        if (questionList[qIndex].answer == answer.text) {
            Toast.makeText(this, "Doğru Cevap", Toast.LENGTH_LONG).show()
            score++
        } else {
            Toast.makeText(this, "Yanlış Cevap\n Cevap = ${questionList[qIndex].answer}", Toast.LENGTH_LONG).show()
        }

    }

    private fun setViews() {

        question_tv.text = questionList[qIndex].question
        option_a_chip.text = questionList[qIndex].optionA
        option_b_chip.text = questionList[qIndex].optionB
        option_c_chip.text = questionList[qIndex].optionC

    }
}
