package com.kip.receiptscanner

import android.content.Context
import android.content.SharedPreferences

class LauncherManager(context: Context) {
    var sharedPreferences: SharedPreferences
    var editor: SharedPreferences.Editor
    fun setFirstLaunch(isFirst: Boolean) {
        editor.putBoolean(IS_FIRST_TIME, isFirst)
        editor.commit()
    }

    val isFirstTime: Boolean
        get() = sharedPreferences.getBoolean(IS_FIRST_TIME, true)

    companion object {
        private const val PREF_NAME = "LaunchManager"
        private const val IS_FIRST_TIME = "isFirst"
    }

    init {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, 0)
        editor = sharedPreferences.edit()
    }
}