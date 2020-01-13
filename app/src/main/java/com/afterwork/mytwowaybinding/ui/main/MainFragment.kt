package com.afterwork.mytwowaybinding.ui.main

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.lifecycle.Observer
import com.afterwork.mytwowaybinding.R
import com.afterwork.mytwowaybinding.databinding.MainFragmentBinding
import com.afterwork.mytwowaybinding.ui.BaseFragment
import android.util.Log
import com.afterwork.mytwowaybinding.BindingType

class MainFragment : BaseFragment<MainFragmentBinding>() {

    companion object {
        fun newInstance() = MainFragment()

        val TAG = "MainFragment"

        var listner:((BindingType)->Unit)? = null
    }

    override val layoutResourceId:Int
        get() = R.layout.main_fragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.vmMain = ViewModelProviders.of(this).get(MainViewModel::class.java)

        // TODO: Use the ViewModel
        binding.vmMain?.postEvent?.observe(this, Observer {
            Log.d(TAG, "New Fragment(@{it})")
            listner?.invoke(it)
        })
    }

    fun setListener(ln: ((BindingType)->Unit)){
        listner = ln
    }

}
