package com.afterwork.mytwowaybinding.ui.custom

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR.runState
import com.afterwork.mytwowaybinding.BR
import com.afterwork.mytwowaybinding.State


data class CustomObservableData(private var runState: State,
                                private var max: Int,
                                private var speed: Int,
                                private var current: Int,
                                private var color: Int): BaseObservable(){

    @Bindable
    fun getRunState() = runState

    @Bindable
    fun getMax() = max

    @Bindable
    fun getSpeed() = speed

    @Bindable
    fun getCurrent() = current

    @Bindable
    fun getColor() = color

    fun setRunState(runState: State){
        this.runState = runState
        notifyPropertyChanged(BR.runState)
    }

    fun setMax(max: Int){
        this.max = max
        notifyPropertyChanged(BR.max)
    }

    fun setSpeed(speed: Int){
        this.speed = speed
        notifyPropertyChanged(BR.speed)
    }

    fun setCurrent(current: Int){
        this.current = current
        notifyPropertyChanged(BR.current)
    }

    fun setColor(color: Int){
        this.color = color
        notifyPropertyChanged(BR.color)
    }
}