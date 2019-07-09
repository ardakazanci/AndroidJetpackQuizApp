/*
 * *
 *  * Created by Arda Kazancı on 7/9/19 6:44 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 7/9/19 6:44 PM
 *
 */

package com.ardakazanci.androidjetpackquizapp.ui.result

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ardakazanci.androidjetpackquizapp.R
import com.ardakazanci.androidjetpackquizapp.util.Constants
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        intent.extras.let {
            // null ' dan farklıysa anlamı taşır.

            val result = intent.extras?.getInt(Constants.EXTRA_RESULT)
            val listSize = intent.extras?.getInt(Constants.EXTRA_LIST_SIZE)
            result_tv.text = "$listSize sorudan $result tanesini doğru bildiniz."

        }


    }
}
