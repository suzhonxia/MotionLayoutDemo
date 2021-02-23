package com.sun.motion

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sun.motion.ui.*
import kotlinx.android.synthetic.main.activity_layout.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_layout)

        init()
    }

    private fun init() {
        btn0.setOnClickListener {
            startActivity(Intent(this, LayoutStep0::class.java))
        }
        btn1.setOnClickListener {
            startActivity(Intent(this, LayoutStep1::class.java))
        }
        btn2.setOnClickListener {
            startActivity(Intent(this, LayoutStep2::class.java))
        }
        btn3.setOnClickListener {
            startActivity(Intent(this, LayoutStep3::class.java))
        }
        btn4.setOnClickListener {
            startActivity(Intent(this, LayoutStep4::class.java))
        }
        btn5.setOnClickListener {
            startActivity(Intent(this, LayoutStep5::class.java))// 在动画执行过程中调用方法
        }
        btn6.setOnClickListener {
            startActivity(Intent(this, LayoutStep6::class.java))// 代码设置属性
        }
        btn7.setOnClickListener {
            startActivity(Intent(this, LayoutStep7::class.java))// 配合ViewPage使用
        }
        btn8.setOnClickListener {
            startActivity(Intent(this, LayoutStep8::class.java))// 代码控制动画执行
        }
        btn9.setOnClickListener {
            startActivity(Intent(this, LayoutStep9::class.java))// 拨号页面
        }
        btn10.setOnClickListener {
            startActivity(Intent(this, LayoutStep10::class.java))// 更复杂的实现
        }
    }
}