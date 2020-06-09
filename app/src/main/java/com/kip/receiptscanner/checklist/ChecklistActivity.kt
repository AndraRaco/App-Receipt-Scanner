package com.kip.receiptscanner.checklist

import android.os.Bundle
import android.util.SparseBooleanArray
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.kip.receiptscanner.R

import kotlinx.android.synthetic.main.activity_checklist.*
import kotlinx.android.synthetic.main.activity_checklist.add
import kotlinx.android.synthetic.main.activity_checklist.clear
import kotlinx.android.synthetic.main.activity_checklist.delete
import kotlinx.android.synthetic.main.app_bar_main_drawer.*
//import kotlinx.android.synthetic.main.fragment_slideshow.*

class ChecklistActivity : AppCompatActivity() {

    class Product(name: String, price: Double) {
        var name : String = ""
        var price : Double = 0.0

        //class Product(val name: String = "", val price: Double = 0.0){}

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checklist)
        setSupportActionBar(toolbar)

        // Initializing the array lists and the adapter

        var itemlist = arrayListOf<Product>()
        listView.adapter = ProductAdapter(this, itemlist)
        /*var adapter = ArrayAdapter<Product>(this,
            android.R.layout.simple_list_item_multiple_choice
            , itemlist)*/

        // Adding the items to the list when the add button is pressed
        add.setOnClickListener {

            var name : String  = editText.text.toString().substringBefore(' ')
            var price : Double = editText.text.toString().substringAfter(' ').toDouble()
            val p =  Product(name, price)
            itemlist.add(p)
            //listView.adapter =  adapter
            (listView.adapter as ProductAdapter).notifyDataSetChanged()
            // This is because every time when you add the item the input space or the edit text space will be cleared
            editText.text.clear()
        }

        // Clearing all the items in the list when the clear button is pressed
        clear.setOnClickListener {
            itemlist.clear()
            (listView.adapter as ProductAdapter).notifyDataSetChanged()
        }

        // Adding the toast message to the list when an item on the list is pressed
        listView.setOnItemClickListener { adapterView, view, i, l ->
            android.widget.Toast.makeText(this, "You Selected "+itemlist.get(i), android.widget.Toast.LENGTH_SHORT).show()
        }

        // Selecting and Deleting the items from the list when the delete button is pressed
        delete.setOnClickListener {
            /*val position: SparseBooleanArray = listView.checkedItemPositions
            val count = listView.count
            var item = count - 1
            while (item >= 0) {
                if (position.get(item))
                {
                    adapter.remove(itemlist.get(item))
                }
                item--
            }
            position.clear()
            adapter.notifyDataSetChanged()*/
        }

    }
}

//package com.kip.receiptscanner.checklist
//
//import android.os.Bundle
//import android.util.SparseBooleanArray
//import android.widget.ArrayAdapter
//import android.widget.LinearLayout
//import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.LinearLayoutManager
//import com.kip.receiptscanner.R
//
//import kotlinx.android.synthetic.main.activity_checklist.*
//import kotlinx.android.synthetic.main.app_bar_main_drawer.*
//
//class ChecklistActivity : AppCompatActivity() {
//
//    inner class Product(name: String, price: Double) {
//        var name: String = ""
//        var price: Double = 0.0
//
//        // Product(val name: String = "", val price: Double = 0.0){}
//
//    }
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_checklist)
//        setSupportActionBar(toolbar)
//
//        recycler_view.layoutManager = LinearLayoutManager(this)
//
//        // Initializing the array lists and the adapter
//        var productNameList = arrayListOf<Product>()
//        recycler_view.adapter = ProductAdapter(productNameList)
//        /*var adapter = ArrayAdapter<Product>(
//            this,
//            android.R.layout.simple_list_item_multiple_choice
//            , productNameList
//        )*/
//
//        // Adding the items to the list when the add button is pressed
//        add.setOnClickListener {
//
//            var name: String = editText.text.toString().substringBefore(' ')
//            var price: Double = editText.text.toString().substringAfter(' ').toDouble()
//            val p = Product(name, price)
//            productNameList.add(p)
//            //listView.adapter = adapter
//            //adapter.notifyDataSetChanged()
//            recycler_view.adapter?.notifyDataSetChanged()
//            // This is because every time when you add the item the input space or the edit text space will be cleared
//            editText.text.clear()
//        }
//
//        // Clearing all the items in the list when the clear button is pressed
//        clear.setOnClickListener {
//            productNameList.clear()
//            //adapter.notifyDataSetChanged()
//            recycler_view.adapter?.notifyDataSetChanged()
//        }
//
//        // Adding the toast message to the list when an item on the list is pressed
//        /*listView.setOnItemClickListener { adapterView, view, i, l ->
//            android.widget.Toast.makeText(
//                this,
//                "You Selected " + productNameList.get(i),
//                android.widget.Toast.LENGTH_SHORT
//            ).show()
//        }*/
//
//        // Selecting and Deleting the items from the list when the delete button is pressed
//        delete.setOnClickListener {
//            /*val position: SparseBooleanArray = listView.checkedItemPositions
//            val count = listView.count
//            var item = count - 1
//            while (item >= 0) {
//                if (position.get(item)) {
//                    adapter.remove(productNameList.get(item))
//                }
//                item--
//            }
//            position.clear()
//            adapter.notifyDataSetChanged()*/
//        }
//
//    }
//}
