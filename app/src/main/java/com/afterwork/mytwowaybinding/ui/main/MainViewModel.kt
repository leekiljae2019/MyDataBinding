package com.afterwork.mytwowaybinding.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.afterwork.mytwowaybinding.BindingType

class MainViewModel : ViewModel() {
    companion object {
        val TAG = "MainViewModel"
    }

    // TODO: Implement the ViewModel
    private val _postEvent: MutableLiveData<BindingType> = MutableLiveData(BindingType.NONE)
    val postEvent: LiveData<BindingType>
        get() = _postEvent


    fun onClick(type: BindingType){
        Log.d(TAG, "onClick(${type})")
        _postEvent.postValue(type)
    }

}
