package com.example.asynctaskprogram

import android.annotation.SuppressLint
import android.os.AsyncTask
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private lateinit var txShow: TextView


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvResult = findViewById(R.id.tvResult)
        txShow = findViewById(R.id.txShow)
        val editText:EditText = findViewById(R.id.editText)

        val btnFetchData: Button = findViewById(R.id.btnFetchData)
        val btn: Button = findViewById(R.id.btn)

        btnFetchData.setOnClickListener(View.OnClickListener {
            FetchDataTask(tvResult).execute()
        })

        btn.setOnClickListener(View.OnClickListener {
            txShow.text = editText.text.toString()

        })

    }




}
 class FetchDataTask(tvResult:TextView) : AsyncTask<Void, Void, String>() {
     val innerTextView: TextView? = tvResult
    // Before running the background task
    override fun onPreExecute() {
        super.onPreExecute()
        // Display a message that the data is being fetched
        innerTextView?.text = "Fetching data..."
    }

    // Perform background task (doInBackground)
    override fun doInBackground(vararg params: Void?): String {
        // Simulate a long-running operation (like a network call)
        try {
            Thread.sleep(6000)  // Simulate a 3-second delay
        } catch (e: InterruptedException) {
            e.printStackTrace()
        }
        return "Data fetched successfully!"
    }

    // After background task completes
    override fun onPostExecute(result: String) {
        super.onPostExecute(result)
        // Update the TextView with the result
        innerTextView?.text = result
    }
}
