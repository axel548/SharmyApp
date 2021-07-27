package com.example.sharmyapplication.network

import com.example.sharmyapplication.model.Order
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreSettings

const val ORDERS_COLLECTION_NAME = "pedido"

class FirestoreService {
    val firebaseFirestore = FirebaseFirestore.getInstance()
    val settings = FirebaseFirestoreSettings.Builder().setPersistenceEnabled(true).build()

    init{
        firebaseFirestore.firestoreSettings = settings
    }

    fun getOrders(callback: Callback<List<Order>>){
        firebaseFirestore.collection(ORDERS_COLLECTION_NAME)
            .get()
            .addOnSuccessListener { result ->
                for (doc in result) {
                    val list = result.toObjects(Order::class.java)
                    callback.onSuccess(list)
                    break
                }
            }
    }

}