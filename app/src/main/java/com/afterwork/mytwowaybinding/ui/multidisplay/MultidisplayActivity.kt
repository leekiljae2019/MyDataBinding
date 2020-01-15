package com.afterwork.mytwowaybinding.ui.multidisplay

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.afterwork.mytwowaybinding.R
import com.afterwork.mytwowaybinding.databinding.MultidisplayActivityBinding
import com.afterwork.mytwowaybinding.databinding.MultidisplayFragmentBinding
import com.afterwork.mytwowaybinding.ui.BaseActivity

class MultidisplayActivity: BaseActivity<MultidisplayActivityBinding>() {
    companion object{
        val TAG = "MultidisplayActivity"
    }

    override val layoutResourceId: Int
        get() = R.layout.multidisplay_activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MultidisplayFragment.newInstance())
                .commitNow()
        }

        binding.vmMulti = ViewModelProviders.of(this).get(MultidisplayViewModel::class.java)

        binding.lifecycleOwner = this
    }
}