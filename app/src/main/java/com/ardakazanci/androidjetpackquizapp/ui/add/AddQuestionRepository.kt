/*
 * *
 *  * Created by Arda Kazancı on 7/9/19 7:13 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 7/9/19 7:13 PM
 *
 */

package com.ardakazanci.androidjetpackquizapp.ui.add

import android.content.Context
import android.os.AsyncTask
import com.ardakazanci.androidjetpackquizapp.data.QuestionDao
import com.ardakazanci.androidjetpackquizapp.data.QuestionDb
import com.ardakazanci.androidjetpackquizapp.model.Question

// Veritabanı ile iletişim kuracak kısım burasıdır.
// Burada soru ekleme işlemini gerçekleştirdik.

class AddQuestionRepository(context: Context) {

    private val db by lazy { QuestionDb.getInstance(context) }

    private val dao by lazy { db.questionDao() }

    // Soru Ekleme işlemi arka planda yapılmalı
    fun insertQuestion(question: Question) {
        InsertAsyncTask(dao).execute(question)
    }

    private class InsertAsyncTask(val dao: QuestionDao) : AsyncTask<Question, Void, Void>() {

        override fun doInBackground(vararg p0: Question?): Void? {

            dao.addQuestion(p0[0]!!)
            return null

        }

    }

}