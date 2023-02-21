package com.example.networkcall

import retrofit2.Response

interface contract {
    interface model{
        fun onQuoteList(onFinishedListener: OnFinishedListener?)
        fun onResults(onFinishedListener: OnFinishedListener?)
        interface OnFinishedListener {
            fun onFinished1(string: QuoteList?)
            fun onFinished2(string:  List<Result>?)
        }
    }

    interface view{
        fun showQuoteList(string: QuoteList?)
        fun showResults(string:  List<Result>?)
    }

    interface presenter{
        fun getQuoteList()
        fun getResults()
    }
}