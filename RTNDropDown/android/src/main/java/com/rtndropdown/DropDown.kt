package com.rtndropdown


import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.LinearLayout
import android.widget.Spinner
import com.facebook.react.bridge.ReactContext
import com.facebook.react.uimanager.UIManagerHelper
import com.facebook.react.uimanager.events.EventDispatcher


class DropDown(context: Context) : LinearLayout(context) {

    var isSpinnerSelected = false
    private var spinner: Spinner

    init {
        val linearLayoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.WRAP_CONTENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
        layoutParams = linearLayoutParams
        orientation = VERTICAL
        spinner = Spinner(context)
        addView(spinner)
    }

    fun configureSpinner(list: ArrayList<String>) {

        val spinnerArrayAdapter =
            ArrayAdapter(context, android.R.layout.simple_spinner_dropdown_item, list)
        spinner.adapter = spinnerArrayAdapter

        spinner.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id1: Long
            ) {
                if (isSpinnerSelected) {
                    val reactContext = context as ReactContext
                    val eventDispatcher: EventDispatcher? =
                        UIManagerHelper.getEventDispatcherForReactTag(
                            reactContext, id
                        )
                    eventDispatcher?.dispatchEvent(DropDownEvent(id, list[position]))
                }
                isSpinnerSelected = true
            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        }
    }
}