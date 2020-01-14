package com.afterwork.mytwowaybinding.ui.observable

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.afterwork.mytwowaybinding.R
import com.afterwork.mytwowaybinding.databinding.ObservableFragmentBinding
import com.afterwork.mytwowaybinding.ui.BaseFragment

class ObservableFragment: BaseFragment<ObservableFragmentBinding>() {

    companion object{
        fun newInstance() = ObservableFragment()
        val TAG = "ObservableFragment"
    }

    override val layoutResourceId:Int
        get() = R.layout.observable_fragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.vmObservable = ViewModelProviders.of(this).get(ObservableViewModel::class.java)
        // TODO: Use the ViewModel
        binding.lifecycleOwner = this
    }
}