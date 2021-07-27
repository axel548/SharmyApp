package com.example.sharmyapplication.ui.main.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.sharmyapplication.R
import com.example.sharmyapplication.model.Order

class OrdersAdapter(val orderListener: OrdersListener): RecyclerView.Adapter<OrdersAdapter.ViewHolder>() {
    var listOrders = ArrayList<Order>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)
        = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_order, parent, false))

    override fun getItemCount() = listOrders.size

    override fun onBindViewHolder(holder: OrdersAdapter.ViewHolder, position: Int) {
        val order:Order = listOrders[position]


        holder.tvPedido.text = "Pedido: " + order.pedido
        holder.tvProduct.text = "Productos: " + order.producto
        holder.tvTotal.text = "Total: Q" +  order.total

        Glide
            .with(holder.itemView.context)
            .load(R.drawable.logo)
            .apply(RequestOptions.circleCropTransform())
            .into(holder.ivLogo)

        holder.itemView.setOnClickListener{
            orderListener.onOrdersClicked(order, position)
        }

    }

    fun updateData(data: List<Order>){
        listOrders.clear()
        listOrders.addAll(data)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvPedido = itemView.findViewById<TextView>(R.id.tvPedido)
        val tvProduct = itemView.findViewById<TextView>(R.id.tvProduc)
        val tvTotal = itemView.findViewById<TextView>(R.id.tvTotal)
        val ivLogo = itemView.findViewById<ImageView>(R.id.ivLogoItem)
    }

}