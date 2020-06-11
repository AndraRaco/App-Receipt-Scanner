package com.kip.receiptscanner

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.kip.receiptscanner.checklist.ChecklistActivity
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class CheckListAndroidTest {
    @Rule
    @JvmField
    val rule: ActivityTestRule<ChecklistActivity> = ActivityTestRule(ChecklistActivity::class.java)

    @Test
    fun user_add_product_correct() {
        // Write product information in typeTexts
        onView(withId(R.id.editText)).perform(typeText("mere"))
        onView(withId(R.id.et_price)).perform(typeText("4.5"))

        var sizeBeforeAdd =
            rule.activity.getItemListSize() // Size of the Checklist before inserting a new element

        // Click on add button
        onView(withId(R.id.add)).perform(click())

        var sizeAfterAdd =
            rule.activity.getItemListSize() // Size of the Checklist after inserting a new element

        // Check if the product was added, the size after add should be equal with the initial size + one
        Assert.assertEquals(
            "The product was not insert in the CheckList",
            (sizeBeforeAdd + 1).toDouble(), sizeAfterAdd.toDouble(), 0.0
        )
    }

    @Test
    fun user_add_product_wrong() {
        // Product name and price
        var nameProduct = "mere"
        var priceProduct = "ciocolata"

        // Write product information in typeTexts
        onView(withId(R.id.editText)).perform(typeText(nameProduct))
        onView(withId(R.id.et_price)).perform(typeText(priceProduct))

        var ok: Boolean = true // Check whether the input was correct or not
        if (priceProduct.toDoubleOrNull() == null) // if price is not double
            ok = false

        if (priceProduct == "" || nameProduct == "") // if price or name is not written
            ok = false

        // Check if the product was added, the size after add should be equal with the initial size + one
        Assert.assertTrue("The product was not insert in the CheckList", ok)
    }

    @Test
    fun user_add_and_delete_product_correct() {
        // Add 2 products to the CheckList
        // Write product information in typeTexts
        onView(withId(R.id.editText)).perform(typeText("mere"))
        onView(withId(R.id.et_price)).perform(typeText("4.5"))
        // Click on add button
        onView(withId(R.id.add)).perform(click())
        // Write product information in typeTexts
        onView(withId(R.id.editText)).perform(typeText("pere"))
        onView(withId(R.id.et_price)).perform(typeText("5.0"))
        // Click on add button
        onView(withId(R.id.add)).perform(click())

        var sizeBeforeDelete =
            rule.activity.getItemListSize() // Size of the Checklist before deleting an element

        // Select "mere" from list
        onView(withText("mere")).perform(click())

        // Delete selected products from CheckList
        onView(withId(R.id.delete)).perform(click())

        var sizeAfterDelete =
            rule.activity.getItemListSize() // Size of the Checklist after deleting an element

        // Check if the product was added, the size after add should be equal with the initial size + one
        Assert.assertEquals(
            "The product was not deleted from the CheckList",
            (sizeBeforeDelete - 1).toDouble(), sizeAfterDelete.toDouble(), 0.0
        )
    }

    @Test
    fun user_add_and_clear_product_correct() {
        // Add 2 products to the CheckList
        // Write product information in typeTexts
        onView(withId(R.id.editText)).perform(typeText("mere"))
        onView(withId(R.id.et_price)).perform(typeText("4.5"))
        // Click on add button
        onView(withId(R.id.add)).perform(click())
        // Write product information in typeTexts
        onView(withId(R.id.editText)).perform(typeText("pere"))
        onView(withId(R.id.et_price)).perform(typeText("5.0"))
        // Click on add button
        onView(withId(R.id.add)).perform(click())

        // Click on clear button
        onView(withId(R.id.clear)).perform(click())

        var sizeAfterClear =
            rule.activity.getItemListSize() // Size of the Checklist after deleting an element

        // Check if the product was added, the size after add should be equal with the initial size + one
        Assert.assertEquals(
            "The product was not deleted from the CheckList",
            0.0, sizeAfterClear.toDouble(), 0.0
        )
    }
}
