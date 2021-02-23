package com.sun.motion.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.core.os.bundleOf
import com.sun.motion.R
import kotlinx.android.synthetic.main.fragment_item.*


private const val AVATAR_ID = "avatar_id"

class ItemFragment : Fragment(R.layout.fragment_item) {

    private var title: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            title = it.getString(AVATAR_ID, "")
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tv.text = title
    }

    companion object {
        @JvmStatic
        fun newInstance(title: String) =
            ItemFragment().apply {
                arguments = bundleOf(AVATAR_ID to title)
            }
    }
}