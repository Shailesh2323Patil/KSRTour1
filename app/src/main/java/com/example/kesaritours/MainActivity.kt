package com.example.kesaritours

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.kesaritours.presentation.ToursInfoScreen
import com.example.kesaritours.presentation.ToursInfoViewModel
import com.example.kesaritours.ui.theme.KesariToursTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel: ToursInfoViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            KesariToursTheme {
                val toursInfoState = viewModel.toursInfoState.value
                val loadingInfoState = viewModel.loadingInfoFlow.value
                val snackBarHostState = remember { SnackbarHostState() }
                val scope = rememberCoroutineScope()

                LaunchedEffect(key1 = true, block = {
                    viewModel.eventFlow.collectLatest { event ->
                        when (event) {
                            is ToursInfoViewModel.UiEvent.ShowSnackBar -> {
                                scope.launch {
                                    snackBarHostState.showSnackbar(message = event.message)
                                }
                            }
                        }
                    }
                })

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(
                                title = {
                                    Row(
                                        modifier = Modifier
                                            .fillMaxWidth()
                                            .fillMaxHeight()
                                    ) {
                                        Text(
                                            modifier = Modifier.align(Alignment.CenterVertically),
                                            text = LocalContext.current.getString(R.string.tours_information),
                                            textAlign = TextAlign.Start,
                                            color = Color.White,
                                            fontSize = 17.sp,
                                            fontStyle = FontStyle.Normal,
                                            fontWeight = FontWeight.Bold,
                                        )
                                    }
                                }
                            )
                        }
                    ) { innerPadding ->
                        Box(
                            modifier = Modifier
                                .padding(innerPadding)
                                .background(Color.White)
                        ) {
                            Column(
                                modifier = Modifier.fillMaxSize()
                            ) {
                                if(toursInfoState.toursInfoItem.isNotEmpty()) {
                                    LazyColumn(modifier = Modifier.fillMaxSize()) {
                                        items(toursInfoState.toursInfoItem.size) { position ->
                                            var tourInfo = toursInfoState.toursInfoItem[position]

                                            Column(
                                                modifier = Modifier
                                                    .padding(
                                                        start = 8.dp,
                                                        end = 8.dp,
                                                        top = 8.dp,
                                                        bottom = 2.dp
                                                    )
                                            ) {
                                                ToursInfoScreen(tourInfo = tourInfo)
                                            }
                                        }
                                    }
                                }
                            }

                            if (loadingInfoState.isLoading) {
                                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
                            }
                        }
                    }
                }
            }
        }

        viewModel.fetchToursInfoData()
    }
}