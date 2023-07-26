package com.example.kesaritours.presentation

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
) : ViewModel() {

    private val _toursInfoFlow = mutableStateOf(ToursInfoState())
    val toursInfoState: State<ToursInfoState> = _toursInfoFlow

    private val _eventFlow = MutableSharedFlow<UiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    private var fetchJob: Job? = null

    fun fetchToursInfoData() {
        fetchJob?.cancel()
        fetchJob = viewModelScope.launch {
            toursInfoUseCase()
                .onEach { result ->
                    when(result) {
                        is Resource.Success -> {
                            _toursInfoFlow.value = _toursInfoFlow.value.copy(
                                toursInfoItem = result.data ?: emptyList() ,
                                isLoading = false
                            )
                        }
                        is Resource.Error -> {
                            _toursInfoFlow.value = _toursInfoFlow.value.copy(
                                toursInfoItem = result.data ?: emptyList() ,
                                isLoading = false
                            )
                            _eventFlow.emit(
                                UiEvent.ShowSnackBar(
                                    result.message ?: "Something Went Wrong"
                                )
                            )
                        }
                        is Resource.Loading -> {
                            _toursInfoFlow.value = _toursInfoFlow.value.copy(
                                toursInfoItem = emptyList() ,
                                isLoading = true
                            )
                        }
                    }
                }
                .launchIn(this)
        }
    }

    sealed class UiEvent {
        data class ShowSnackBar(val message: String) : UiEvent()
    }
}