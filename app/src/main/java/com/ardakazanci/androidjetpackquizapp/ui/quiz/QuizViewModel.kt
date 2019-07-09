/*
 * *
 *  * Created by Arda Kazancı on 7/9/19 2:36 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 7/9/19 2:36 PM
 *
 */

package com.ardakazanci.androidjetpackquizapp.ui.quiz

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ardakazanci.androidjetpackquizapp.model.Question


// AndroidViewModel Context'ten haberdar view model ' dir.

class QuizViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: QuizRepository by lazy { QuizRepository(application) }

    // Bu variable gözlemlenecek
    val allQuestions: LiveData<List<Question>> by lazy { repository.getAllQuestions() }
}