/*
 * *
 *  * Created by Arda Kazancı on 7/9/19 4:37 PM
 *  * Copyright (c) 2019 . All rights reserved.
 *  * Last modified 7/9/19 4:37 PM
 *
 */

package com.ardakazanci.androidjetpackquizapp

import android.app.Application
import com.facebook.stetho.Stetho

class QuizApp : Application() {
    // Application Class 'ı tüm uygulamayı kapsar.
    override fun onCreate() {
        super.onCreate()

        Stetho.initializeWithDefaults(this);

    }
}