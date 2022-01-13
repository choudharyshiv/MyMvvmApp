package com.zopsmart.mvvmfirstapp.ViewModel

import com.zopsmart.mvvmfirstapp.model.Blog
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class MainViewModel: ViewModel() {
    var lst = MutableLiveData<ArrayList<Blog>>()
    var newlist = arrayListOf<Blog>()

    fun add(blog: Blog){
        newlist.add(blog)
        lst.value=newlist
    }

    fun remove(blog: Blog){
        newlist.remove(blog)
        lst.value=newlist
    }

}