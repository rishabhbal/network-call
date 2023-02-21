package com.example.networkcall

import android.util.Log

class presenter(var model: contract.model, var view: contract.view): contract.presenter,
    contract.model.OnFinishedListener {
    override fun getQuoteList() {
        model.onQuoteList(this)
    }

    override fun getResults() {
        model.onResults(this)
    }

    override fun onFinished1(result: QuoteList?) {
//        Log.i("Count", result!!.count.toString())
//        Log.i("Last Item Index", result!!.lastItemIndex.toString())
//        Log.i("Page", result!!.page.toString())
//        Log.i("Total Count", result!!.totalCount.toString())
//        Log.i("Total Pages", result!!.totalPages.toString())
        view.showQuoteList(result)
    }

    override fun onFinished2(result:  List<Result>?) {
//        for (item in result!!.indices) {
//            Log.i("Value $item", "" +
//                    "Author: ${result[item].author} \n " +
//                    "Quote: ${result[item].content} \n" +
//                    "Tags: ${result[item].tags} \n" +
//                    "Date Added: ${result[item].dateAdded}")
//        }
        view.showResults(result)
    }


}