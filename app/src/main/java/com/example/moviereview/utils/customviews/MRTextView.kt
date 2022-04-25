package com.example.moviereview.utils.customviews

import android.content.Context
import android.util.AttributeSet
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.res.ResourcesCompat
import com.example.moviereview.R

class MRTextView(context: Context, attrs: AttributeSet): AppCompatTextView(context, attrs) {
    init {
        typeface = ResourcesCompat.getFont(context, R.font.montserratregular)
    }
}