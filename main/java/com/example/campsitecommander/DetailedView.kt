package com.example.campsitecommander

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DetailedView : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_detailed_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnDisplay = findViewById<Button>(R.id.btnDisplay)// Find button by ID
        val txtViewList = findViewById<TextView>(R.id.txtViewList)// Find TextView by ID
        val btnBack = findViewById<Button>(R.id.btnBack)// Find button by ID
        btnDisplay.setOnClickListener {
            var output = ""// Initialize output string
            for (i in 0 until MainActivity1.itemArray.size) {// Loop through arrays
                output += """
                    Item: ${MainActivity1.itemArray[i]}// Display the list
                    Category: ${MainActivity1.categoryArray[i]}
                    Quantity: ${MainActivity1.quantityArray[i]}
                    Comments: ${MainActivity1.commentsArray[i]}
                    
                    """.trimIndent()// Append item details to output

                output += "\n\n"// Add line break after each item
            }
            txtViewList.text = output// Set TextView text to output

            Log.d("CampsiteCommander_APP", "Displayed full packing list")
        }
        btnBack.setOnClickListener {
            val intent = Intent(this, MainActivity1::class.java)
            startActivity(intent)// Navigate to MainActivity
        }
    }
}