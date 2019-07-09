/*
 * *
 *  * Created by Arda Kazancı on 7/8/19 11:31 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 7/8/19 11:31 PM
 *
 */

package com.ardakazanci.androidjetpackquizapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

// TABLO - BÖLÜM 1


@Entity(tableName = "questions") // Table name
data class Question(

    @PrimaryKey(autoGenerate = true)
    var qid: Int = 0,

    var question: String,

    @ColumnInfo(name = "option_a") // Kolon İsimleri
    var optionA: String,
    @ColumnInfo(name = "option_b")
    var optionB: String,
    @ColumnInfo(name = "option_c")
    var optionC: String,

    var answer: String


)