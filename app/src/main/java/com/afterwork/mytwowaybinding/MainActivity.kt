package com.afterwork.mytwowaybinding

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.lifecycle.Observer
import com.afterwork.mytwowaybinding.ui.liveData.LiveDataFragment
import com.afterwork.mytwowaybinding.ui.main.MainFragment
import com.afterwork.mytwowaybinding.ui.observable.ObservableFragment

class MainActivity : AppCompatActivity() {

    companion object{
        val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment.newInstance())
                .commitNow()

            MainFragment.newInstance().setListener {
                Log.d(TAG, "New Fragment(@{it})")
                when(it){
                    BindingType.LIVEDATA -> supportFragmentManager.beginTransaction()
                        .replace(R.id.container, LiveDataFragment.newInstance())
                        .commitNow()
                    BindingType.OBSERVABLE -> supportFragmentManager.beginTransaction()
                        .replace(R.id.container, ObservableFragment.newInstance())
                        .commitNow()

                }
            }
        }
    }

//    override fun onResume() {
//        super.onResume()
//
//        MainFragment.newInstance().binding.vmMain?.postEvent?.observe(this, Observer {
//            Log.d(TAG, "New Fragment(@{it})")
//            when(it){
//                BindingType.LIVEDATA -> supportFragmentManager.beginTransaction()
//                    .replace(R.id.container, LiveDataFragment.newInstance())
//                    .commitNow()
//                BindingType.OBSERVABLE -> supportFragmentManager.beginTransaction()
//                    .replace(R.id.container, ObservableFragment.newInstance())
//                    .commitNow()
//
//            }
//        })
//    }

}
