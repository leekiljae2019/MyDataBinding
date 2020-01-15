package com.afterwork.mytwowaybinding.ui.multidisplay2

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.afterwork.mytwowaybinding.R
import com.afterwork.mytwowaybinding.databinding.Multidisplay2FragmentBinding
import com.afterwork.mytwowaybinding.ui.BaseFragment
import com.afterwork.mytwowaybinding.ui.multidisplay.MultidisplayFragment

class Multidisplay2Fragment: BaseFragment<Multidisplay2FragmentBinding>(){
    companion object {
        fun newInstance() = Multidisplay2Fragment()

        val TAG = "Multidisplay2Fragment"
    }

    override val layoutResourceId:Int
        get() = R.layout.multidisplay2_fragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.vmMulti2 = Multidisplay2ViewModel
        // TODO: Use the ViewModel
    }
}