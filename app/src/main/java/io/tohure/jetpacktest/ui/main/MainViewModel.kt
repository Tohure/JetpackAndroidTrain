package io.tohure.jetpacktest.ui.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    private val _data = MutableLiveData<String>()
    private var id  = ""

    val data: LiveData<String>
        get() = _data

    init {
        _data.value = "Hello, Jetpack!"
    }

    fun init(id : String){
        this.id = id
    }
}
