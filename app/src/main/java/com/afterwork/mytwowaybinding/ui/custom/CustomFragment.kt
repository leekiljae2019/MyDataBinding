package com.afterwork.mytwowaybinding.ui.custom

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.afterwork.mytwowaybinding.R
import com.afterwork.mytwowaybinding.databinding.CustomFragmentBinding
import com.afterwork.mytwowaybinding.ui.BaseFragment

class CustomFragment: BaseFragment<CustomFragmentBinding>(){
    companion object {
        fun newInstance() = CustomFragment()

        val TAG = "CustomFragment"
    }

    override val layoutResourceId:Int
        get() = R.layout.custom_fragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.vmCustom = ViewModelProviders.of(this).get(CustomViewModel::class.java)
        // TODO: Use the ViewModel
        binding.lifecycleOwner = this
    }
}