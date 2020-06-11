package com.kip.receiptscanner

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.ml.vision.FirebaseVision
import com.google.firebase.ml.vision.common.FirebaseVisionImage
import com.google.firebase.ml.vision.text.FirebaseVisionText
import com.kip.receiptscanner.checklist.ChecklistActivity
import java.util.*


class MainTextRecognizer : AppCompatActivity() {

    lateinit var imageView: ImageView
    lateinit var editText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageView = findViewById(R.id.imageView)
        editText = findViewById(R.id.editText)
    }


    fun selectImage(v: View) {
        val intent = Intent()
        intent.type = "image/*"
        intent.action = Intent.ACTION_GET_CONTENT
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), 1)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == Activity.RESULT_OK) {
            imageView.setImageURI(data!!.data)

        }
    }

    fun startRecognizing(v: View) {
        if (imageView.drawable != null) {
            editText.setText("")
            v.isEnabled = false
            val bitmap = (imageView.drawable as BitmapDrawable).bitmap
            val image = FirebaseVisionImage.fromBitmap(bitmap)
            val detector = FirebaseVision.getInstance().onDeviceTextRecognizer

            detector.processImage(image)
                .addOnSuccessListener { firebaseVisionText ->
                    v.isEnabled = true
                    processResultText(firebaseVisionText)

                    var toCheckList: List<String?>//list to send to checklist activity
                    toCheckList = ArrayList(50)

                    var products : List<Pair<Double, String>>//auxiliary list to make tochecklist
                    products = processResultText(firebaseVisionText)

                    for(x in products)
                        toCheckList.add(x.first.toString() + ',' +x.second)
                    //pass the products array to checklist for merging
                    val Checklist = Intent(this, ChecklistActivity::class.java)
                    Checklist.putExtra("Products", toCheckList)
                    startActivity(Checklist)

                }
                .addOnFailureListener {
                    v.isEnabled = true
                    editText.setText("Failed")
                }
        } else {
            Toast.makeText(this, "Select an Image First", Toast.LENGTH_LONG).show()
        }
    }


    private fun processResultText(resultText: FirebaseVisionText) : List<Pair<Double, String>> {

        var products : List<Pair<Double, String>>
        products = ArrayList(50)

        if (resultText.textBlocks.size == 0) {
            editText.setText("No Text Found")
            return products
        }

        for (block in resultText.textBlocks) {
            val blockText = block.text
            editText.append(blockText + "\n")
        }

        val tuples = getTuples(editText.text.toString())
        products = getTuples(editText.text.toString())
        editText.setText("")
        for (t in tuples) {
            editText.append(t.toString() + "\n")
        }
        return products
    }

    fun getTuples(text: String): List<Pair<Double, String>> {
        var products = mutableListOf<Pair<Double, String>>()
        var produs_crt = 0
        var pret_crt = 0
        var nume_crt = 0
        var started = false
        val lines = text.split("\n")
        for (line in lines) {
            if ("total" == line.toLowerCase(Locale.getDefault())
                || "*" in line.toLowerCase(Locale.getDefault())) {
                break
            }

            if ("x " in line.toLowerCase(Locale.getDefault())) {
                val trimmedLine = line.drop(line.toLowerCase(Locale.getDefault()).indexOf("x ") + 2)
                if (trimmedLine.isEmpty()) {
                    continue
                }
                val words = trimmedLine.split(' ')
                if (words.isNotEmpty()) {
                    if (words[0].toDoubleOrNull() != null) {
                        val nr = words[0].toDouble()
                        if (pret_crt == produs_crt) {
                            products.add(Pair(nr, ""))
                            produs_crt += 1
                            pret_crt += 1
                        } else {
                            products[pret_crt] = Pair(nr, products[pret_crt].second)
                            pret_crt += 1
                        }
                        started = true;
                    }
                }
            } else if (started
                && !line[0].isDigit()
                && "discount" !in line.toLowerCase(Locale.getDefault())
                && "total" !in line.toLowerCase(Locale.getDefault())
                && "lei" != line.toLowerCase(Locale.getDefault())
                && "lel" != line.toLowerCase(Locale.getDefault())) {

                if (nume_crt == produs_crt) {
                    products.add(Pair(0.toDouble(), line))
                    produs_crt += 1
                    nume_crt += 1
                } else {
                    products[nume_crt] = Pair(products[nume_crt].first, line)
                    nume_crt += 1
                }
            }
        }
        return products
    }
}