package com.example.kesaritours.presentation

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kesaritours.base.BaseViewModel
import com.example.kesaritours.domain.usecase.ToursInfoUseCase
import com.example.kesaritours.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ToursInfoViewModel @Inject constructor(
    private val toursInfoUseCase : ToursInfoUseCase
) : BaseViewModel() {

    private val _toursInfoFlow = mutableStateOf(ToursInfoState())
    val toursInfoState: State<ToursInfoState> = _toursInfoFlow

    private val _loadingInfoFlow = mutableStateOf(LoadingInfoState())
    val loadingInfoFlow: State<LoadingInfoState> = _loadingInfoFlow

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun fetchToursInfoData() {
        toursInfoUseCase.execute {
            onLoading {
                _loadingInfoFlow.value = _loadingInfoFlow.value.copy(
                    isLoading = it
                )
            }
            onComplete { result ->
                _toursInfoFlow.value = _toursInfoFlow.value.copy(
                    toursInfoItem = result
                )
            }
            onCancel { result ->
                viewModelScope.launch {
                    _eventFlow.emit(
                        UiEvent.ShowSnackBar(
                            result.message ?: "Something Went Wrong"
                        )
                    )
                }
            }
            onError { result ->
                viewModelScope.launch {
                    _eventFlow.emit(
                        UiEvent.ShowSnackBar(
                            result.message ?: "Something Went Wrong"
                        )
                    )
                }
            }
        }
    }

    sealed class UiEvent {
        data class ShowSnackBar(val message: String) : UiEvent()
    }
}