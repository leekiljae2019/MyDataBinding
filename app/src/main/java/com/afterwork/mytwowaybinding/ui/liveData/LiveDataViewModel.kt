package com.afterwork.mytwowaybinding.ui.liveData

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.afterwork.mytwowaybinding.R
import com.afterwork.mytwowaybinding.State
import java.util.*
import kotlin.concurrent.timer
import kotlin.random.Random

class LiveDataViewModel: ViewModel() {
    companion object {
        val TAG = "LiveDataViewModel"
    }

    // TODO: Implement the ViewModel
    private val _runState: MutableLiveData<State> = MutableLiveData(State.STOP)
    val runState: LiveData<State> get() = _runState

    private val _max: MutableLiveData<Int> = MutableLiveData(100)
    val max: LiveData<Int> get() = _max

    private val _speed: MutableLiveData<Int> = MutableLiveData(1)
    val speed: LiveData<Int> get() = _speed

    private val _current: MutableLiveData<Int> = MutableLiveData(0)
    val current: LiveData<Int> get() = _current

    private val _color: MutableLiveData<Int> = MutableLiveData(R.color.pastel0)
    val color: LiveData<Int> get() = _color

    var _timer: Timer? = null

    fun onClick(state: State){
        when(state){
            State.STOP -> start()
            State.PAUSE -> run()
            State.RUN -> pause()
        }
    }

    fun start(){
        Log.d(TAG, "setState is START")

        _max.value = Random.nextInt(100, 200)
        _speed.value = Random.nextInt(1, 5)
        _current.value = 0
        _color.value = R.color.pastel1
        run()
    }

    fun run(){
        Log.d(TAG, "setState is RUN")
        _timer = timer(period = 500){
            if (_current.value!!.toInt() >= _max.value!!.toInt()) {
                stop()
            } else if (_runState.value == State.RUN) {
                _current.postValue(_current.value!! + _speed.value!!)
                _color.postValue(randColor())
                Log.d(TAG, "_current = ${_current.value}, _max = ${_max.value}, color = ${_color.value}")
            }
        }

        _runState.value = State.RUN
    }

    fun pause(){
        _runState.postValue(State.PAUSE)
        _timer?.cancel()
    }

    fun stop(){
        _runState.postValue(State.STOP)
        _timer?.cancel()
    }

    fun randColor(): Int{
        when(Random.nextInt(9)){
            0 -> return R.color.pastel0
            1 -> return R.color.pastel1
            2 -> return R.color.pastel2
            3 -> return R.color.pastel3
            4 -> return R.color.pastel4
            5 -> return R.color.pastel5
            6 -> return R.color.pastel6
            7 -> return R.color.pastel7
            8 -> return R.color.pastel8
            else -> return R.color.pastel9
        }
    }
}