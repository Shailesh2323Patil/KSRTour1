package com.example.kesaritours.data.usecase.base

import com.example.kesaritours.data.mapper.CloudErrorMapper
import com.example.kesaritours.data.mapper.model.ErrorModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception
import java.util.concurrent.CancellationException
import kotlin.coroutines.CoroutineContext

typealias CompletionBlock<T> = UseCase.Response<T>.() -> Unit

abstract class UseCase<T>(private val errorUtil: CloudErrorMapper) {

    private var parentJob: Job = Job()
    var backgroundContext: CoroutineContext = Dispatchers.IO

    protected abstract suspend fun executeOnBackground(): T

    fun execute(block: CompletionBlock<T>) {
        val response = Response<T>().apply { block() }
        unsubscribe()

        parentJob = Job()

        CoroutineScope(parentJob).launch {
            try {
                response(true)
                val result = withContext(backgroundContext) {
                    executeOnBackground()
                }
                response(result)
                response(false)
            }
            catch (cancellationException : CancellationException) {
                response(false)
                response(cancellationException)
            }
            catch (exception : Exception) {
                val error = errorUtil.mapToDomainErrorException(exception)
                response(false)
                response(error)
            }
        }
    }

    private fun unsubscribe() {
        parentJob.apply {
            cancelChildren()
            cancel()
        }
    }

    class Response<T> {
        private var onLoading: ((Boolean)-> Unit)? = null
        private var onComplete: ((T)-> Unit)? = null
        private var onError: ((ErrorModel) -> Unit)? = null
        private var onCancel: ((CancellationException) -> Unit)? = null

        fun onLoading(block: (Boolean) -> Unit) {
            onLoading = block
        }

        fun onComplete(block: (T)-> Unit) {
            onComplete = block
        }

        fun onError(block: (ErrorModel) -> Unit) {
            onError = block
        }

        fun onCancel(block: (CancellationException) -> Unit) {
            onCancel = block
        }

        operator fun invoke(loader: Boolean) {
            onLoading?.let {
                it.invoke(loader)
            }
        }

        operator fun invoke(result: T) {
            onComplete?.let {
                it.invoke(result)
            }
        }

        operator fun invoke(errorModel: ErrorModel) {
            onError?.let {
                it.invoke(errorModel)
            }
        }

        operator fun invoke(error: CancellationException) {
            onCancel?.let {
                it.invoke(error)
            }
        }
    }

}