/*
 * *
 *  * Created by Arda Kazancı on 7/9/19 2:32 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 7/9/19 2:32 PM
 *
 */

package com.ardakazanci.androidjetpackquizapp.ui.quiz

import android.content.Context
import androidx.lifecycle.LiveData
import com.ardakazanci.androidjetpackquizapp.data.QuestionDao
import com.ardakazanci.androidjetpackquizapp.data.QuestionDb
import com.ardakazanci.androidjetpackquizapp.model.Question

// Veritabanı ile iletişim halinde olacak, aldığı değerleri viewModel a gönderecek
class QuizRepository(context: Context) {


    // 1. Adım
    private val db by lazy { QuestionDb.getInstance(context) }
    // 2. Adım
    private val dao: QuestionDao by lazy { db.questionDao() }

    // by lazy nin diğer yolu init blogu içinde yapmaktır.

    // 3. Adım
    // Veritabanında ki bütün soruları getir.
    // Bu metodu çalıştıracak olan ViewModel tanımlanacaktır.
    fun getAllQuestions(): LiveData<List<Question>> = dao.getQuestions()


}