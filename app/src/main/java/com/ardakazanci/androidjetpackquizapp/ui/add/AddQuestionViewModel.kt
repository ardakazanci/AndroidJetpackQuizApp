/*
 * *
 *  * Created by Arda Kazancı on 7/9/19 7:28 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 7/9/19 7:28 PM
 *
 */

package com.ardakazanci.androidjetpackquizapp.ui.add

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.ardakazanci.androidjetpackquizapp.model.Question

class AddQuestionViewModel(application: Application) : AndroidViewModel(application) {
    // AddQuestionRepository ' den yeni bir nesne ürettik.
    private val repository: AddQuestionRepository by lazy { AddQuestionRepository(application) }

    // Kullanıcıdan alınan viewmodel nesnesi question olarak repository ' e pas atılıyor.
    fun insert(question: Question) = repository.insertQuestion(question)

}