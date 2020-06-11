package com.kip.receiptscanner

import com.kip.receiptscanner.checklist.ChecklistActivity
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class CheckListUnitTest {

    var checklist = ChecklistActivity()

    @Test
    fun test_sum() {
        // Create list of prices of products {2.0, 3.0, 15.0}
        var prices = ArrayList<Double>()
        prices.add(2.0)
        prices.add(3.0)
        prices.add(15.0)

        // Call sumAux method
        var result: Double = checklist.sumAux(prices)
        var expectedResult: Double = 20.0

        // Check if the sumAux method returns the expected value
        assertEquals("the sum did not work properly", expectedResult, result, 0.0)
    }
}
