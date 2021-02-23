package com.sun.motion.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sun.motion.R
import kotlinx.android.synthetic.main.layout_step_8.*

// 代码控制动画执行
class LayoutStep8 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_step_8)

        initStep8()
    }

    private fun initStep8() {
        // 代码执行动画
        // 修复OnClick重复点击动画会重头开始的问题
        label.setOnClickListener {
            // 运动中currentState的值是-1 不做处理
            if (motionLayout8.currentState == -1) {
                return@setOnClickListener
            }

            if (motionLayout8.currentState == motionLayout8.startState) {
                motionLayout8.transitionToEnd()
            } else if (motionLayout8.currentState == motionLayout8.endState) {
                motionLayout8.transitionToStart()
            }
        }
    }
}