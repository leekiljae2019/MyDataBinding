package com.afterwork.mytwowaybinding.ui.multidisplay

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.afterwork.mytwowaybinding.R
import com.afterwork.mytwowaybinding.databinding.MultidisplayFragmentBinding
import com.afterwork.mytwowaybinding.ui.BaseFragment

class MultidisplayFragment: BaseFragment<MultidisplayFragmentBinding>(){
    companion object {
        fun newInstance() = MultidisplayFragment()

        val TAG = "MultidisplayFragment"
    }

    override val layoutResourceId:Int
        get() = R.layout.multidisplay_fragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.vmMulti = ViewModelProviders.of(requireActivity()).get(MultidisplayViewModel::class.java)
        // TODO: Use the ViewModel
    }
}