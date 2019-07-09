/*
 * *
 *  * Created by Arda Kazancı on 7/8/19 11:42 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 7/8/19 11:42 PM
 *
 */

package com.ardakazanci.androidjetpackquizapp.data

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.ardakazanci.androidjetpackquizapp.model.Question

// DATABASE - BÖLÜM 3

@Database(entities = arrayOf(Question::class), version = 1) // arrayOf -> Oluşturulan enttyler verilir.
abstract class QuestionDb : RoomDatabase() {

    abstract fun questionDao(): QuestionDao


    companion object {

        @Volatile // Geçici
        var INSTANCE: QuestionDb? = null

        @Synchronized
        fun getInstance(context: Context): QuestionDb {

            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    QuestionDb::class.java,
                    "question_db"
                ).addCallback(roomDbCallback)
                    .build()
            }

            return INSTANCE as QuestionDb

        }

        // Veritabanı oluşturulduğunda otomatik olarak dolu gelecek

        private val roomDbCallback = object : RoomDatabase.Callback() {

            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
                PopulateAsyncTask(INSTANCE).execute()
            }

        }


        class PopulateAsyncTask(private val db: QuestionDb?) : AsyncTask<Void, Void, Void>() {

            private val dao: QuestionDao? by lazy { db?.questionDao() }

            override fun doInBackground(vararg p0: Void?): Void? {

                var question = Question(

                    question = "Soru 1",
                    optionA = "A Şıkkı",
                    optionB = "B Şıkkı",
                    optionC = "C Şıkkı",
                    answer = "A Şıkkı"

                )

                dao?.addQuestion(question)

                question = Question(

                    question = "Soru 1",
                    optionA = "A Şıkkı",
                    optionB = "B Şıkkı",
                    optionC = "C Şıkkı",
                    answer = "B Şıkkı"

                )

                dao?.addQuestion(question)

                question = Question(

                    question = "Soru 1",
                    optionA = "A Şıkkı",
                    optionB = "B Şıkkı",
                    optionC = "C Şıkkı",
                    answer = "C Şıkkı"

                )

                dao?.addQuestion(question)

                return null

            }


        }


    }

}