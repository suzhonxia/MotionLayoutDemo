package com.sun.motion.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.sun.motion.R
import com.sun.motion.fragment.ItemFragment
import kotlinx.android.synthetic.main.layout_step_7.*

// 配合ViewPage使用
class LayoutStep7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_step_7)

        initStep7()
    }

    private fun initStep7() {
        val count = 5
        vp.adapter = object : FragmentPagerAdapter(supportFragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
            override fun getCount(): Int = count

            override fun getPageTitle(position: Int): CharSequence = position.toString()

            override fun getItem(position: Int): Fragment = ItemFragment.newInstance(position.toString())
        }
        tabs.setupWithViewPager(vp)

        vp.addOnPageChangeListener(object : ViewPager.SimpleOnPageChangeListener() {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                (motionLayout7 as? MotionLayout)?.progress = (position + positionOffset) / (count - 1)
            }
        })
    }
}