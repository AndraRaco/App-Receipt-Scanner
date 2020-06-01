package com.kip.receiptscanner

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.Window
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity

class Splash : AppCompatActivity() {
    var launcherManager: LauncherManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //hide statusbar
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_splash)
        launcherManager = LauncherManager(this)
        Handler().postDelayed({
            if (launcherManager!!.isFirstTime) {
                launcherManager!!.setFirstLaunch(false)
                startActivity(Intent(applicationContext, Slider::class.java))
            } else startActivity(Intent(applicationContext, MainDrawer::class.java))
        }, 2000)
    }
}