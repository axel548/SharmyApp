package com.example.sharmyapplication.ui.main.adapter

import com.example.sharmyapplication.model.Order

interface OrdersListener {
    fun onOrdersClicked(order: Order, position: Int)
}