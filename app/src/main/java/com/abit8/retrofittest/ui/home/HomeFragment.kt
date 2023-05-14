package com.abit8.retrofittest.ui.home

import by.kirich1409.viewbindingdelegate.viewBinding
import com.abit8.retrofittest.R
import com.abit8.retrofittest.base.BaseFragment
import com.abit8.retrofittest.databinding.FragmentHomeBinding
import com.abit8.retrofittest.utils.NetworkChangeListener

class HomeFragment :
    BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
    override val binding by viewBinding(FragmentHomeBinding::bind)
    override val networkChangeListener: NetworkChangeListener by lazy {
        NetworkChangeListener()
    }
}