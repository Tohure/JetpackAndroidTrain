package io.tohure.jetpacktest.ui.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class UserViewModel : ViewModel() {

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
