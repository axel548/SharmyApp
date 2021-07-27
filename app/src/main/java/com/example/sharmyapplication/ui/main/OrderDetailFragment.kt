package com.example.sharmyapplication.ui.main

import android.app.Dialog
import android.content.DialogInterface
import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.core.os.bundleOf
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.findNavController
import com.example.sharmyapplication.R
import com.example.sharmyapplication.databinding.FragmentOrderDetailBinding
import com.example.sharmyapplication.databinding.FragmentOrdersBinding
import com.example.sharmyapplication.model.Order
import java.text.SimpleDateFormat

class OrderDetailFragment : DialogFragment(){

    private var _binding: FragmentOrderDetailBinding? = null
    private val binding get() = _binding!!


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialogStyle)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentOrderDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbarOrderDetail.navigationIcon = ContextCompat.getDrawable(view.context, R.drawable.ic_close)
        binding.toolbarOrderDetail.setNavigationOnClickListener {
            dismiss()
        }

        val order = arguments?.getSerializable("order") as Order

        binding.tvNoPedido.text = order.pedido
        binding.tvTotalPedido.text = "Q"+order.total
    }


    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}