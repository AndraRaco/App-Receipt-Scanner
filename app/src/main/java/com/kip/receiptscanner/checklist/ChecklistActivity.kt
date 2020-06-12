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

    private var itemList = arrayListOf<Product>() // List of the products

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
            var sum = calculatePriceToPay()
            // Show a text with the sum
            android.widget.Toast.makeText(
                this,
                "You have to pay $sum",
                android.widget.Toast.LENGTH_SHORT
            ).show()
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

    // Adding a new row to the CheckList
    fun addRow() {
        // Create product with name and prace
        val name = editText.text.toString()
        val price = et_price.text.toString().toDouble()
        val p = Product(name, price)

        // Add product to the list of Products
        itemList.add(p)

        // Notify the attached observers that the underlying data has been changed and
        // the listView should refresh itself
        (listView.adapter as ProductAdapter).notifyDataSetChanged()

        // After adding the item, the edit texts for name and for price will be cleared
        editText.text.clear()
        et_price.text.clear()
    }

    // Delete the selected rows form the listView
    fun deleteRow() {
        val position: SparseBooleanArray =
            listView.checkedItemPositions // Map with indices of the items from listView
        // and true/false if the item is checked/ is not checked
        val count = listView.count // size of the listView
        var item = count - 1 // index for the list

        // Removing the selected items
        while (item >= 0) {
            if (position.get(item)) {
                itemList.removeAt(item)
            }
            item--
        }
        position.clear()

        // Notify the attached observers that the underlying data has been changed and
        // the listView should refresh itself
        (listView.adapter as ProductAdapter).notifyDataSetChanged()
    }

    // Delete the all rows form the listView
    fun clearRows() {
        itemList.clear()

        // Notify the attached observers that the underlying data has been changed and
        // the listView should refresh itself
        (listView.adapter as ProductAdapter).notifyDataSetChanged()
    }

    // Sum of the elements of an ArrayList
    fun sumAux(prices: ArrayList<Double>): Double {
        return prices.sum()
    }

    // Calculate how much the user has to pay
    fun calculatePriceToPay(): Double {
        val position: SparseBooleanArray =
            listView.checkedItemPositions // Map with indices of the items from listView
        // and true/false if the item is checked/ is not checked
        val count = listView.count // Size of the listView

        var pricesOfProducts: ArrayList<Double> = ArrayList<Double>()

        // Select the products that are checked
        var item = count - 1
        while (item >= 0) {
            if (position.get(item)) {
                pricesOfProducts.add(itemList[item].price)
            }
            item--
        }

        // Calculate the sum of the selected products
        return sumAux(pricesOfProducts)
    }

    // Size of the itemList
    fun getItemListSize(): Int {
        return itemList.size
    }
}
