package com.afterwork.mytwowaybinding.ui.multidisplay2

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.afterwork.mytwowaybinding.R
import com.afterwork.mytwowaybinding.databinding.Multidisplay2ActivityBinding
import com.afterwork.mytwowaybinding.ui.BaseActivity

class Multidisplay2Activity: BaseActivity<Multidisplay2ActivityBinding>() {
    companion object{
        val TAG = "Multidisplay2Activity"
    }

    override val layoutResourceId: Int
        get() = R.layout.multidisplay2_activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, Multidisplay2Fragment.newInstance())
                .commitNow()
        }

        binding.vmMulti2 = Multidisplay2ViewModel
    }
}