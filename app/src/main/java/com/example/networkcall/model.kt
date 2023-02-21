package com.example.networkcall

import android.util.Log
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class model: contract.model {
    val quotesApi = RetrofitHelper.getInstance().create(QuotesApi::class.java)

    override fun onQuoteList(listener: contract.model.OnFinishedListener?) {
        GlobalScope.launch {
            val result = quotesApi.getQuotes().body()
            listener!!.onFinished1(result)
        }
    }

    override fun onResults(listener: contract.model.OnFinishedListener?) {
        GlobalScope.launch {
            val result = quotesApi.getQuotes().body()?.results
            listener!!.onFinished2(result)
        }
    }
}