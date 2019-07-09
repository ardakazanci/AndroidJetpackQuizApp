/*
 * *
 *  * Created by Arda Kazancı on 7/8/19 11:35 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 7/8/19 11:35 PM
 *
 */

package com.ardakazanci.androidjetpackquizapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ardakazanci.androidjetpackquizapp.model.Question

// DAO - BÖLÜM 2


@Dao
interface QuestionDao {

    @Query("SELECT * FROM questions")
    fun getQuestions(): LiveData<List<Question>> // Tüm soruları gözlemlenecek şekilde tanımladık.

    @Insert(onConflict = OnConflictStrategy.REPLACE) // var olan bir veri eklenmeye çalışınca yapılcak strateji.
    fun addQuestion(question: Question)

    @Query("DELETE FROM questions")
    fun deleteAll()

}