package com.kip.receiptscanner

import android.app.Activity
import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import android.os.Bundle
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

                    var tes: List<String?>
                    var test: List<String?>
                    test = ArrayList(200)

                    var produse : List<Pair<Double, String>>
                    produse = processResultText(firebaseVisionText)


                    for(x in produse)
                        test.add(x.first.toString() + ',' +x.second)

                    val i = Intent(this, ChecklistActivity::class.java)
                    i.putExtra("key", test)
                    startActivity(i)
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


        /*
        if (resultText.textBlocks.size == 0) {
            editText.setText("No Text Found")
            return
        }*/

        for (block in resultText.textBlocks) {
            val blockText = block.text
            editText.append(blockText + "\n")
            //tes.add(blockText)
        }

        val tuples = getTuples(editText.text.toString())
        editText.setText("")
        for (t in tuples) {
            editText.append(t.toString() + "\n")
        }
        return tuples

    }

    fun getTuples(text: String): List<Pair<Double, String>> {
        var produse = mutableListOf<Pair<Double, String>>()
        var produs_crt = 0
        var pret_crt = 0
        var nume_crt = 0
        var started = false
        val lines = text.split("\n")
        for (line in lines) {
           // if ("lei" in line.toLowerCase(Locale.getDefault())) {
          //      started = true
           //     continue
         //   }
         //   if (!started) {
         //       continue
        //    }
            if ("total" == line.toLowerCase(Locale.getDefault())) {
                break
            }

            if (" buc" in line.toLowerCase(Locale.getDefault())) {
                val words = line.split(' ')
                if (words.size >= 4) {
                    if (words[3].toDoubleOrNull() != null) {
                        val nr = words[3].toDouble()
                        if (pret_crt == produs_crt) {
                            produse.add(Pair(nr, "") as Pair<Double, String>)
                            produs_crt += 1
                            pret_crt += 1
                        } else {
                            produse[pret_crt] = Pair(nr, produse[pret_crt].second)
                            pret_crt += 1
                        }

                        }

                }
            }

            else if (!line[0].isDigit() && "discount" !in line.toLowerCase(Locale.getDefault())
                && "total" !in line.toLowerCase(Locale.getDefault())){
                if (nume_crt == produs_crt) {
                    produse.add(Pair(0.toDouble(), line))
                    produs_crt += 1
                    nume_crt += 1
                } else {
                    produse[nume_crt] = Pair(produse[nume_crt].first, line)
                    nume_crt += 1
                }
            }
        }
        return produse
    }
}