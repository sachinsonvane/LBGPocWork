package com.ss.lloydsbankpoc.presentation.main.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {


}

sealed class MainChannel {
    data class ShowErrorToast(val message: String) : MainChannel()
    data class ShowSuccessToast(val message: String) : MainChannel()
}