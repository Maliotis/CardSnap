package com.maliotis.cardsnap

import android.content.res.Resources
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.setMargins

fun ViewGroup.LayoutParams.setMargin(margin: Int) {
    if (this is ConstraintLayout.LayoutParams) {
        this.setMargins(margin)
    }
    // add more
}
val Int.dp: Int get() = (this / Resources.getSystem().displayMetrics.density).toInt()
