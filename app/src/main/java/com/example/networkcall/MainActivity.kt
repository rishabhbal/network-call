package com.example.networkcall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global
import android.util.Log
import android.widget.Button
import android.widget.TextView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit

class MainActivity : AppCompatActivity(), contract.view {

    var textView: TextView? = null
    var getQuotes: Button? = null
    var getResult: Button? = null
    var presenter: presenter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        getQuotes = findViewById(R.id.button2)
        getResult = findViewById(R.id.button3)

        presenter = presenter(model(), this)

        getQuotes?.setOnClickListener {
            presenter?.getQuoteList()
        }

        getResult?.setOnClickListener {
            presenter?.getResults()
        }
    }

    override fun showQuoteList(result: QuoteList?) {
        Log.i("Count", result!!.count.toString())
        Log.i("Last Item Index", result!!.lastItemIndex.toString())
        Log.i("Page", result!!.page.toString())
        Log.i("Total Count", result!!.totalCount.toString())
        Log.i("Total Pages", result!!.totalPages.toString())
    }

    override fun showResults(result:  List<Result>?) {
        for (item in result!!.indices) {
            Log.i("Value $item", "" +
                    "Author: ${result[item].author} \n " +
                    "Quote: ${result[item].content} \n" +
                    "Tags: ${result[item].tags} \n" +
                    "Date Added: ${result[item].dateAdded}")
        }
    }
}