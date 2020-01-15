package com.afterwork.mytwowaybinding

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.afterwork.mytwowaybinding.ui.custom.CustomFragment
import com.afterwork.mytwowaybinding.ui.liveData.LiveDataFragment
import com.afterwork.mytwowaybinding.ui.main.MainFragment
import com.afterwork.mytwowaybinding.ui.multidisplay.MultidisplayActivity
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
                    BindingType.CUSTOM -> supportFragmentManager.beginTransaction()
                        .replace(R.id.container, CustomFragment.newInstance())
                        .commitNow()
                    BindingType.MULTI -> startActivity(Intent(this@MainActivity, MultidisplayActivity::class.java))
                }
            }
        }
    }
}
