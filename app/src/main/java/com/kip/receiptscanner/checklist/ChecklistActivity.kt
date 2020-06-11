package com.kip.receiptscanner.checklist

import android.os.Bundle
import android.util.SparseBooleanArray
import android.widget.CheckBox
import androidx.appcompat.app.AppCompatActivity
import com.kip.receiptscanner.Product
import com.kip.receiptscanner.R
import kotlinx.android.synthetic.main.activity_checklist.*
import kotlinx.android.synthetic.main.app_bar_main_drawer.*

class ChecklistActivity : AppCompatActivity() {

    private var itemList = arrayListOf<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checklist)
        setSupportActionBar(toolbar)

        // Initializing the array lists and the adapter
        listView.adapter = ProductAdapter(this, itemList)

        // Adding the items to the list when the add button is pressed
        add.setOnClickListener {
            addRow()
        }

        // Clearing all the items in the list when the clear button is pressed
        clear.setOnClickListener {
            clearRows()
        }

        // Adding the toast message to the list when an item on the list is pressed
        listView.setOnItemClickListener { adapterView, view, i, l ->
            android.widget.Toast.makeText(
                this,
                "You Selected " + itemList.get(i).name + " " + itemList.get(i).price,
                android.widget.Toast.LENGTH_SHORT
            ).show()
            val position: SparseBooleanArray = listView.checkedItemPositions

            // Tick the checkbox
            val checkbox = view.findViewById<CheckBox>(R.id.checkBox)
            checkbox!!.isChecked = position[i]

        }

        // Selecting and Deleting the items from the list when the delete button is pressed
        delete.setOnClickListener {
            deleteRow()
        }

        // Calculate how much has the person to pay
        calculate.setOnClickListener {
            calculatePriceToPay()
        }

        // Get an string array containing ("price" + "," + "name") for each product in scanner
        val products = intent.getStringArrayListExtra("Products")

        // If the list of products is not null
        if (products != null) {
            for (x in products) {
                val parts = x.split(',').toTypedArray() // parse to get the products

                // Create Product object
                val price = parts[0].toDouble()
                val name = parts[1]
                val p = Product(name, price)

                itemList.add(p) // add each element from the products to the itemList
            }
        }
    }

    fun addRow() {
        val name = editText.text.toString()
        val price = et_price.text.toString().toDouble()
        val p = Product(name, price)
        itemList.add(p)
        //listView.adapter =  adapter
        (listView.adapter as ProductAdapter).notifyDataSetChanged()
        // This is because every time when you add the item the input space or the edit text space will be cleared
        editText.text.clear()
        et_price.text.clear()
    }

    fun deleteRow() {
        val position: SparseBooleanArray = listView.checkedItemPositions
        val count = listView.count
        var item = count - 1
        while (item >= 0) {
            if (position.get(item)) {
                itemList.removeAt(item)
            }
            item--
        }
        position.clear()
        (listView.adapter as ProductAdapter).notifyDataSetChanged()
    }

    fun clearRows() {
        itemList.clear()
        (listView.adapter as ProductAdapter).notifyDataSetChanged()
    }

    fun sumAux(prices: ArrayList<Double>): Double {
//        var sum: Double = 0.0
//        var item = prices.size - 1
//
//        while (item >= 0) {
//            val priceOfProduct = prices[item]
//            sum += priceOfProduct
//            item--
//        }
        return prices.sum()
    }

    fun calculatePriceToPay() {
        val position: SparseBooleanArray = listView.checkedItemPositions
        val count = listView.count

        var pricesOfProducts: ArrayList<Double> = ArrayList<Double>()

        var item = count - 1
        while (item >= 0) {
            if (position.get(item)) {
                pricesOfProducts.add(itemList[item].price)
            }
            item--
        }

        var sum = sumAux(pricesOfProducts)

        android.widget.Toast.makeText(
            this,
            "You have to pay $sum",
            android.widget.Toast.LENGTH_SHORT
        ).show()
    }
}
