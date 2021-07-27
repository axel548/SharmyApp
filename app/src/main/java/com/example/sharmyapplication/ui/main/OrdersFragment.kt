package com.example.sharmyapplication.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sharmyapplication.R
import com.example.sharmyapplication.databinding.FragmentOrdersBinding
import com.example.sharmyapplication.model.Order
import com.example.sharmyapplication.ui.main.adapter.OrdersAdapter
import com.example.sharmyapplication.ui.main.adapter.OrdersListener
import com.example.sharmyapplication.viewmodel.OrderViewModel
import com.google.android.material.snackbar.Snackbar


class OrdersFragment : Fragment(), OrdersListener {

    private lateinit var orderAdapter: OrdersAdapter
    private lateinit var viewModel: OrderViewModel

    private var _binding: FragmentOrdersBinding? = null
    private val binding get() = _binding!!
    
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOrdersBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(OrderViewModel::class.java)
        viewModel.refresh()

        orderAdapter = OrdersAdapter(this)

        binding.rcOrder.apply {
            layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL, false)
            adapter = orderAdapter
        }
        observeViewModel()
    }

    fun observeViewModel(){
        viewModel.listOrder.observe(viewLifecycleOwner, Observer<List<Order>> { orders ->
            orderAdapter.updateData(orders)
        })

        viewModel.isLoading.observe(viewLifecycleOwner, Observer<Boolean> {
            if (it != null)
                binding.rlOrders.visibility = View.INVISIBLE
        })
    }

    override fun onOrdersClicked(order: Order, position: Int) {
//        val bundle = bundleOf("order" to order)
//        findNavController().navigate(R.id.orderDetailFragment, bundle)
        Toast.makeText(context, "Pedido", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}