package com.afterwork.mytwowaybinding.ui.multidisplay

import android.util.Log
import androidx.lifecycle.ViewModel
import com.afterwork.mytwowaybinding.R
import com.afterwork.mytwowaybinding.State
import com.afterwork.mytwowaybinding.ui.custom.CustomObservableData
import java.util.*
import kotlin.concurrent.timer
import kotlin.random.Random

class MultidisplayViewModel: ViewModel() {
    companion object{
        val TAG = "MultidisplayViewModel"
    }

    val data = CustomObservableData(State.STOP, 100, 1, 0, R.color.pastel0)

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
        data.setMax(Random.nextInt(100, 200))
        data.setSpeed(Random.nextInt(1, 5))
        data.setCurrent(0)
        data.setColor(R.color.pastel1)
        run()
    }

    fun run(){
        Log.d(TAG, "setState is RUN")
        _timer = timer(period = 500){
            if (data.getCurrent() >= data.getMax()) {
                stop()
            } else if (data.getRunState() == State.RUN) {
                data.setCurrent(data.getCurrent() + data.getSpeed())
                data.setColor(randColor())
                Log.d(TAG, "current = ${data.getCurrent()}, max = ${data.getMax()}, color = ${data.getColor()}")
            }
        }

        data.setRunState(State.RUN)
    }

    fun pause(){
        data.setRunState(State.PAUSE)
        _timer?.cancel()
    }

    fun stop(){
        data.setRunState(State.STOP)
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