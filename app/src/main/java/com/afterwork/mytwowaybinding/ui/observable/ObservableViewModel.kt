package com.afterwork.mytwowaybinding.ui.observable

import android.util.Log
import androidx.databinding.ObservableField
import androidx.databinding.ObservableInt
import androidx.lifecycle.ViewModel
import com.afterwork.mytwowaybinding.R
import com.afterwork.mytwowaybinding.State
import java.util.*
import kotlin.concurrent.timer
import kotlin.random.Random


class ObservableViewModel: ViewModel() {
    companion object {
        val TAG = "ObservableViewModel"
    }

    val runState: ObservableField<State> = ObservableField<State>(State.STOP)
    val max: ObservableInt = ObservableInt(100)
    val speed: ObservableInt = ObservableInt(1)
    val current: ObservableInt = ObservableInt(0)
    val color: ObservableInt = ObservableInt(R.color.pastel0)

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
        max.set(Random.nextInt(100, 200))
        speed.set(Random.nextInt(1, 5))
        current.set(0)
        color.set(R.color.pastel1)
        run()
    }

    fun run(){
        Log.d(TAG, "setState is RUN")
        _timer = timer(period = 500){
            if (current.get() >= max.get()) {
                stop()
            } else if (runState.get() == State.RUN) {
                current.set(current.get() + speed.get())
                color.set(randColor())
                Log.d(TAG, "current = ${current.get()}, max = ${max.get()}, color = ${color.get()}")
            }
        }

        runState.set(State.RUN)
    }

    fun pause(){
        runState.set(State.PAUSE)
        _timer?.cancel()
    }

    fun stop(){
        runState.set(State.STOP)
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