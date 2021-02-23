package com.sun.motion.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import com.sun.motion.R
import com.sun.motion.custom.SimpleTransitionListener
import com.xw.repo.BubbleSeekBar
import kotlinx.android.synthetic.main.layout_step_10.*
import java.math.BigDecimal

// 更复杂的实现
class LayoutStep10 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_step_10)

        initStep10()
    }

    private fun initStep10() {
        val size = 4
        val unit = 450
        minLayout.removeAllViews()
        for (i in 0 until size) {
            minLayout.addView(LayoutInflater.from(this).inflate(R.layout.layout_step_10_item, minLayout, false).apply {
                this.findViewById<TextView>(R.id.icon).text = String.format("LV ${i + 1}")
                this.findViewById<TextView>(R.id.tv).text = String.format("巴拉巴拉巴拉拔了吧了吧 -- $i")
            })
        }

        val toStart: () -> Unit = {
            motionLayout10.setTransitionDuration(duration.progress * unit)
            motionLayout10.transitionToStart()
        }
        val toEnd: () -> Unit = {
            motionLayout10.setTransitionDuration(duration.progress * unit)
            motionLayout10.transitionToEnd()
        }

        action10.setOnClickListener {
            if (motionLayout10.currentState == -1) {
                return@setOnClickListener
            }

            if (motionLayout10.currentState == motionLayout10.startState) {
                toEnd.invoke()
            } else if (motionLayout10.currentState == motionLayout10.endState) {
                toStart.invoke()
            }
        }
        ivBig.setOnClickListener {
            if (motionLayout10.currentState == motionLayout10.startState) {
                toEnd.invoke()
            }
        }
        play.setOnClickListener {
            if (motionLayout10.currentState == motionLayout10.endState) {
                toStart.invoke()
            }
        }

        tvDuration.text = String.format("$unit ms")
        duration.onProgressChangedListener = object : BubbleSeekBar.OnProgressChangedListener {
            override fun onProgressChanged(bubbleSeekBar: BubbleSeekBar?, progress: Int, progressFloat: Float, fromUser: Boolean) {
                tvDuration.text = String.format("${unit * progress} ms")
            }

            override fun getProgressOnActionUp(bubbleSeekBar: BubbleSeekBar?, progress: Int, progressFloat: Float) {

            }

            override fun getProgressOnFinally(bubbleSeekBar: BubbleSeekBar?, progress: Int, progressFloat: Float, fromUser: Boolean) {

            }
        }

        checkbox.setOnCheckedChangeListener { _, checked ->
            motionLayout10.setDebugMode(if (checked) 3 else 0)
        }

        motionLayout10.setTransitionListener(object : SimpleTransitionListener() {
            private var lastP = 0.0F
            private val minSize = 120
            private val maxSize = 150

            override fun onTransitionChange(p0: MotionLayout?, p1: Int, p2: Int, p3: Float) {
                val percent = tran(p3.toDouble())
                Log.d("test", "onTransitionChange p = $p3, percent = $percent")
                if (lastP != percent) {
                    lastP = percent
                    Log.d("test", "onTransitionChange lastP = $lastP")
                    for (i in 0 until minLayout.childCount) {
                        (minLayout.getChildAt(i) as? ConstraintLayout)?.let {
                            val set = ConstraintSet()
                            set.clone(it)
                            set.constrainWidth(R.id.icon, (minSize + (maxSize - minSize) * lastP).toInt())
                            set.constrainHeight(R.id.icon, (minSize + (maxSize - minSize) * lastP).toInt())
                            set.applyTo(it)
                        }
                    }
                }
            }

            private fun tran(d: Double): Float {
                if (d == 0.0) {
                    return 0F
                }
                return BigDecimal(d).setScale(1, BigDecimal.ROUND_HALF_UP).toFloat()
            }
        })
    }
}