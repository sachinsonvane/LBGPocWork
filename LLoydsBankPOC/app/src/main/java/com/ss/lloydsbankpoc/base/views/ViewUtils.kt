package com.ss.lloydsbankpoc.base.views

import androidx.annotation.StringRes
import com.ss.lloydsbankpoc.R


sealed class ViewStatus {
    object Inital : ViewStatus()
    object Loading : ViewStatus()

    object Success : ViewStatus()

    class Error(
        val message: String,
        @StringRes val buttonText: Int = R.string.retry,
        val action: (() -> Unit)? = null
    ) : ViewStatus()
}
