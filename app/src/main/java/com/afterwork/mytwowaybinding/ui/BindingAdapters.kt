package com.afterwork.mytwowaybinding.ui

import android.graphics.drawable.Drawable
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.afterwork.mytwowaybinding.State


@BindingAdapter("visibility")
fun visibility(view: View, state: State){
    when(state){
        State.RUN, State.PAUSE -> view.visibility = View.VISIBLE
        else -> view.visibility = View.GONE
    }
}

@BindingAdapter("background")
fun background(view: ImageView, color: Int){
    view.setBackgroundColor(ContextCompat.getColor(view.context, color))
}

@BindingAdapter("intToText")
fun intToText(view: TextView, value: Int){
   view.setText(value.toString())
}

@BindingAdapter("runStateText")
fun runStateText(button: Button, state: State){
    when(state){
        State.RUN -> button.setText("RUN")
        State.PAUSE -> button.setText("PAUSE")
        else -> button.setText("STOP")
    }
}

@BindingAdapter(value = ["maxText","speedText", "currentText"], requireAll = true)
fun mergeText(view: TextView, max: Int, speed: Int, current: Int){
    view.setText("Values: ${max}, ${speed}, ${current}")
}