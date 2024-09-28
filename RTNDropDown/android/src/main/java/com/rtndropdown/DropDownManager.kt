package com.rtndropdown

import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReadableArray
import com.facebook.react.uimanager.SimpleViewManager
import com.facebook.react.uimanager.ThemedReactContext
import com.facebook.react.uimanager.ViewManagerDelegate
import com.facebook.react.uimanager.annotations.ReactProp
import com.facebook.react.viewmanagers.RTNDropDownManagerDelegate
import com.facebook.react.viewmanagers.RTNDropDownManagerInterface


class DropDownManager(private val context: ReactApplicationContext) :
    SimpleViewManager<DropDown>(),
    RTNDropDownManagerInterface<DropDown> {

    private val mDelegate: ViewManagerDelegate<DropDown>

    init {
        mDelegate = RTNDropDownManagerDelegate(this)
    }

    override fun getDelegate(): ViewManagerDelegate<DropDown> {
        return mDelegate
    }

    override fun getName(): String {
        return NAME
    }

    companion object {
        const val NAME = "RTNDropDown"
    }

    override fun createViewInstance(p0: ThemedReactContext): DropDown {
        return DropDown(context)
    }

    @ReactProp(name = "values")
    override fun setValues(view: DropDown?, value: ReadableArray?) {
        val colorsCollection: ArrayList<String> = ArrayList()
        for (i in 0 until value?.size()!!) {
            colorsCollection.add(value.getString(i))
        }
        view!!.configureSpinner(colorsCollection)
    }

}