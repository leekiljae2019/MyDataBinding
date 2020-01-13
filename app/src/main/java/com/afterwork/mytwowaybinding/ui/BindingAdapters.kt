package com.afterwork.mytwowaybinding.ui

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingConversion
import com.afterwork.mytwowaybinding.R
import com.afterwork.mytwowaybinding.State

@BindingAdapter("visibility")
fun visibility(view: View, state: State){
    when(state){
        State.RUN, State.PAUSE -> view.visibility = View.VISIBLE
        else -> view.visibility = View.GONE
    }
}

//@BindingAdapter("progress")
//fun progress(progress: ProgressBar, value: Int){
//    progress.progress = value
//}

@BindingAdapter("background")
fun background(view: ImageView, color: Int){
    view.setBackgroundColor(ContextCompat.getColor(view.context, color))
}

@BindingAdapter("intToText")
fun intToText(view: TextView, value: Int){
   view.setText(value.toString())
}