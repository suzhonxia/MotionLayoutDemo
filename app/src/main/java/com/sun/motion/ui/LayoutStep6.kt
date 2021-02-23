package com.sun.motion.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.Constraints
import com.sun.motion.R
import kotlinx.android.synthetic.main.layout_step_6.*

// 代码设置属性
class LayoutStep6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_step_6)

        initStep6()
    }

    private fun initStep6() {
        btn_1.setOnClickListener {
            motionLayout6.getConstraintSet(R.id.end).getConstraint(R.id.box).apply {
                layout.topToTop = Constraints.LayoutParams.PARENT_ID
                layout.endToEnd = Constraints.LayoutParams.PARENT_ID
                layout.bottomToBottom = Constraints.LayoutParams.PARENT_ID

                transform.rotationY = 180F
                transform.rotationX = 0F
                propertySet.alpha = 0.1f
            }
        }
        btn_2.setOnClickListener {
            motionLayout6.getConstraintSet(R.id.end).getConstraint(R.id.box).apply {
                layout.topToTop = Constraints.LayoutParams.PARENT_ID
                layout.endToEnd = Constraints.LayoutParams.PARENT_ID
                layout.bottomToBottom = Constraints.LayoutParams.UNSET

                transform.rotationY = 180F
                transform.rotationX = 0F
            }
        }
    }
}