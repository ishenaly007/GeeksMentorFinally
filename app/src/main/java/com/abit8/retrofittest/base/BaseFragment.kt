package com.abit8.retrofittest.base

import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import by.kirich1409.viewbindingdelegate.viewBinding
import com.abit8.retrofittest.databinding.FragmentHomeBinding
import com.abit8.retrofittest.utils.NetworkChangeListener

@Suppress("DEPRECATION")
abstract class BaseFragment<Binding : ViewBinding>(@LayoutRes layoutId: Int) : Fragment(layoutId) {
    protected abstract val binding: Binding

    protected open val networkChangeListener: NetworkChangeListener by lazy {
        NetworkChangeListener()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        setRequests()
        setSubscribers()
        initListeners()
    }

    protected open fun initListeners() {}

    protected open fun setSubscribers() {}

    protected open fun setRequests() {}

    protected open fun init() {}

    override fun onStart() {
        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        requireActivity().registerReceiver(networkChangeListener, filter)
        super.onStart()
    }

    override fun onStop() {
        requireActivity().unregisterReceiver(networkChangeListener)
        super.onStop()
    }
//    BaseFragment<FragmentHomeBinding>(R.layout.fragment_home) {
//        override val binding by viewBinding(FragmentHomeBinding::bind)
//        override val networkChangeListener: NetworkChangeListener by lazy {
//            NetworkChangeListener()
//        }подобным образом изменить отстальные фрагменты
}