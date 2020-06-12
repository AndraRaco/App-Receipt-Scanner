package com.kip.receiptscanner.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.kip.receiptscanner.MainTextRecognizer
import com.kip.receiptscanner.R
import com.kip.receiptscanner.checklist.ChecklistActivity
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        openchecklistpart.setOnClickListener {
            var intent = Intent(
                view.context,
                ChecklistActivity::class.java
            )
            startActivity(intent)
        }

        openscanpart.setOnClickListener {
            var intent = Intent(
                view.context,
                MainTextRecognizer::class.java
            )
            startActivity(intent)
        }
    }
}
