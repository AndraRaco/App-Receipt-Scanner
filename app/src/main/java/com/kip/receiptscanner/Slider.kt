package com.kip.receiptscanner

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener

class Slider : AppCompatActivity() {
    lateinit var viewPager: ViewPager
    lateinit var btnNext: Button
    lateinit var btnSkip: Button
    lateinit var layouts: IntArray
    var adapter: Adapter? = null
    val launcherManager: LauncherManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //hide statusbar
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        this.window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        setContentView(R.layout.activity_slider)
        viewPager = findViewById(R.id.pager)
        btnNext = findViewById(R.id.nextbtn)
        btnSkip = findViewById(R.id.skipbtn)
        layouts = intArrayOf(
            R.layout.welcome_slider1,
            R.layout.welcome_slider2,
            R.layout.welcome_slider3
        )
        adapter = Adapter(this, layouts)
        viewPager.setAdapter(adapter)
        btnNext.setOnClickListener(View.OnClickListener {
            if (viewPager.getCurrentItem() + 1 < layouts.size) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1)
            } else {
                //go to main activity
                //launcherManager.setFirstLaunch(false);
                startActivity(Intent(applicationContext, MainDrawer::class.java))
            }
        })
        btnSkip.setOnClickListener(View.OnClickListener {
            startActivity(
                Intent(
                    applicationContext,
                    MainDrawer::class.java
                )
            )
        })
        viewPager.addOnPageChangeListener(viewPagerChangeListener)
    }

    var viewPagerChangeListener: OnPageChangeListener = object : OnPageChangeListener {
        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int
        ) {
        }

        override fun onPageSelected(position: Int) {
            if (position == layouts.size - 1) {
                btnNext!!.text = "Start"
            } else {
                btnNext!!.text = "Next"
            }
        }

        override fun onPageScrollStateChanged(state: Int) {}
    }
}