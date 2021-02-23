package com.sun.motion.ui

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.sun.motion.R
import kotlinx.android.synthetic.main.layout_step_9.*

// 拨号页面
class LayoutStep9 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_step_9)

        initStep9()
    }

    private fun initStep9() {
        val data = mutableListOf(
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15",
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15"
        )
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = object : BaseQuickAdapter<String, BaseViewHolder>(android.R.layout.simple_list_item_1, data) {
            override fun convert(holder: BaseViewHolder, item: String) {
                holder.setText(android.R.id.text1, item)
            }
        }

        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            private var state: Int = RecyclerView.SCROLL_STATE_IDLE

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                state = newState
            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dx == 0 && dy == 0) {
                    return
                }

                if (state == RecyclerView.SCROLL_STATE_DRAGGING && motionLayout9.currentState == motionLayout9.startState) {
                    motionLayout9.transitionToEnd()
                }
            }
        })

        action.setOnClickListener {
            // 运动中currentState的值是-1 不做处理
            if (motionLayout9.currentState == -1) {
                return@setOnClickListener
            }

            if (motionLayout9.currentState == motionLayout9.endState) {
                motionLayout9.transitionToStart()
            }
        }

        motionLayout9.setTransitionListener(object : MotionLayout.TransitionListener {
            override fun onTransitionStarted(p0: MotionLayout?, start: Int, end: Int) {
                Log.d("test", "initStep9 onTransitionStarted start = $start, end = $end")
            }

            override fun onTransitionChange(p0: MotionLayout?, start: Int, end: Int, percent: Float) {
                Log.d("test", "initStep9 onTransitionChange start = $start, end = $end, percent = $percent")
            }

            override fun onTransitionCompleted(p0: MotionLayout?, end: Int) {
                Log.d("test", "initStep9 onTransitionCompleted end = $end")
            }

            override fun onTransitionTrigger(p0: MotionLayout?, p1: Int, p2: Boolean, p3: Float) {}
        })
    }
}