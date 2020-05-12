package com.example.webserviceurlconnection

import android.app.Activity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Button

import androidx.appcompat.app.AppCompatActivity

import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    internal lateinit var contentTV: TextView

    override fun onCreate(savedInstanceveState: Bundle?) {
        super.onCreate(savedInstanceveState)
        setContentView(R.layout.activity_main)
        contentTV = findViewById(R.id.contentTV)
    }

    fun LoadData(view: View) {

        Thread(object : Runnble() {
            override fun run() {

                val Link = "https://jsonplaceholder.typicode.com/posts"
                var inputStream: InputStream? = null

                try {
                    val url = URL(Link)
                    val urlConnection = url.openConnection() as HttpURLConnection
                    inputStream = urlConnection.inputStream
                    var c = 0
                    val buffer = StringBuffer()
                    buffer.append(c.toChar())


                    val result = buffer.toString()
                    runOnUiThread { contentTV.text = result }

                } catch (e: IOException) {
                    e.printStackTrace()

                }

            }

        }).start()
    }

    public open inner class Runnble : Runnable {

        override fun run() {

        }
    }
}




