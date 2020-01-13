package com.afterwork.mytwowaybinding.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import com.afterwork.mytwowaybinding.R
import com.afterwork.mytwowaybinding.databinding.MainFragmentBinding

abstract class BaseFragment<T : ViewDataBinding>: Fragment(){

    abstract val layoutResourceId: Int
    lateinit var binding: T

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutResourceId, container, false)

        return binding.root
    }
}
