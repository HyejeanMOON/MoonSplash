package com.hyejeanmoon.wallpaperbyunsplash.presentation

import android.view.View
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import dagger.android.support.DaggerAppCompatActivity

open class BaseActivity : DaggerAppCompatActivity() {

    /**
     * Set color of statusbar
     */
    protected fun setStatusBarColor(@ColorRes color: Int, isLightStatusBar: Boolean) {
        window.statusBarColor = ContextCompat.getColor(this, color)
        if (isLightStatusBar) {
            // 背景が白の時、文字が黒になる
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        } else {
            // 背景が白ではない時、文字は白にする
            window.decorView.systemUiVisibility = 0
        }
    }
}