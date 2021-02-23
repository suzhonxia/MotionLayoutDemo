package com.sun.motion.custom

import android.content.Context
import android.graphics.drawable.LayerDrawable
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatImageView
import com.sun.motion.R

class CrossFadeImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    private var layerDrawable: LayerDrawable? = null

    /**
     * 控制src图片透明度
     */
    var srcAlpha = 0f
        set(value) {
            field = value
            layerDrawable?.getDrawable(0)?.alpha = (255 * value).toInt()
            invalidate()
        }

    /**
     * 控制altSrc图片透明度
     */
    var altSrcAlpha = 0f
        set(value) {
            field = value
            layerDrawable?.getDrawable(1)?.alpha = (255 * value).toInt()
            invalidate()
        }

    init {
        val a = getContext().obtainStyledAttributes(attrs, R.styleable.CrossFadeImageView)
        val altSrc = a.getDrawable(R.styleable.CrossFadeImageView_altSrc)
        a.recycle()
        if (altSrc != null) {
            altSrc.alpha = 0
            layerDrawable = LayerDrawable(arrayOf(drawable, altSrc))
            super.setImageDrawable(layerDrawable)
        }
    }
}