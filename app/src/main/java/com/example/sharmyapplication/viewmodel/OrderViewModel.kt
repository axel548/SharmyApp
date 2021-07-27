package com.example.sharmyapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.sharmyapplication.model.Order
import com.example.sharmyapplication.network.Callback
import com.example.sharmyapplication.network.FirestoreService
import java.lang.Exception

class OrderViewModel: ViewModel() {

    val firestoreService = FirestoreService()
    var listOrder: MutableLiveData<List<Order>> = MutableLiveData()
    var isLoading = MutableLiveData<Boolean>()

    fun refresh(){
        getOrderFromFirebase()
    }

    fun getOrderFromFirebase(){
        firestoreService.getOrders(object: Callback<List<Order>>{
            override fun onSuccess(result: List<Order>?) {
                listOrder.postValue(result)
                processFinished()
            }

            override fun onFailed(exception: Exception) {
                processFinished()
            }
        })
    }

    fun processFinished() {
        isLoading.value = true
    }
}