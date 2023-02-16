package com.turgutcanozdemir.android.app.geonames.countrysearch.viewmodel.adapter

import android.content.Context
import android.widget.ArrayAdapter

class CountryListAdapter<T>(
    context: Context,
    items: MutableList<T> = arrayListOf()
) : ArrayAdapter<T>(context, android.R.layout.simple_list_item_1, items) {
    override fun add(t: T?) {
        super.add(t)
        notifyDataSetChanged()
    }
}