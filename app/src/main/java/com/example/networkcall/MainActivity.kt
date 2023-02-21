package com.example.networkcall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global
import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    var textView: TextView? = null
    var resultStr: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)

        val quotesApi = RetrofitHelper.getInstance().create(QuotesApi::class.java)

        GlobalScope.launch {
            val result = quotesApi.getQuotes().body()

            Log.i("Count", result!!.count.toString())
            Log.i("Last Item Index", result!!.lastItemIndex.toString())
            Log.i("Page", result!!.page.toString())
            Log.i("Total Count", result!!.totalCount.toString())
            Log.i("Total Pages", result!!.totalPages.toString())

            for (item in result!!.results.indices) {
                Log.i("Value $item", "" +
                        "Author: ${result!!.results[item].author} \n " +
                        "Quote: ${result!!.results[item].content} \n" +
                        "Tags: ${result!!.results[item].tags} \n" +
                        "Date Added: ${result!!.results[item].dateAdded}")
            }
        }
    }
}