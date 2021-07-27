package com.example.sharmyapplication.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.sharmyapplication.R


class SectionsPagerAdapter(fm: FragmentManager)
    : FragmentPagerAdapter(fm) {

    //Get Fragment to use
    override fun getItem(position: Int): Fragment {
        // getItem is called to instantiate the fragment for the given page.
        // Return a PlaceholderFragment (defined as a static inner class below).
        return when(position){
            0 -> OrdersFragment()
            1 -> EstadisticsFragment()
            else ->{
                return OrdersFragment()
            }
        }
    }

    // Get title of the Fragment
    override fun getPageTitle(position: Int): CharSequence? {
        return when(position){
            0 -> "Pedidos"
            1 -> "Estadísticas"
            else ->{
                return "Pedidos"
            }
        }
    }

    //Count fragments to use
    override fun getCount(): Int {
        // Show 2 total pages.
        return 2
    }
}