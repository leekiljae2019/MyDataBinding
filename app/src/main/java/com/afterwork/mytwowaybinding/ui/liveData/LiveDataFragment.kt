package com.afterwork.mytwowaybinding.ui.liveData

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.afterwork.mytwowaybinding.R
import com.afterwork.mytwowaybinding.databinding.LivedataFragmentBinding
import com.afterwork.mytwowaybinding.ui.BaseFragment

class LiveDataFragment : BaseFragment<LivedataFragmentBinding>() {

    companion object {
        fun newInstance() = LiveDataFragment()

        val TAG = "LiveDataFragment"
    }

    override val layoutResourceId:Int
        get() = R.layout.livedata_fragment

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.vmLiveData = ViewModelProviders.of(this).get(LiveDataViewModel::class.java)
        // TODO: Use the ViewModel
        binding.lifecycleOwner = this
    }

}
