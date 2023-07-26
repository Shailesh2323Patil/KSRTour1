package com.example.kesaritours.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.example.kesaritours.R
import com.example.kesaritours.domain.model.Tours


@Composable
fun ToursInfoScreen(tourInfo : Tours) {

    var context = LocalContext.current

    Column(
        modifier = Modifier
            .height(170.dp)
            .fillMaxWidth()
    ) {
        Card(
            shape = RoundedCornerShape(8.dp),
            backgroundColor = Color.White,
            elevation = 8.dp
        ) {
            Row() {
                Box(
                    Modifier
                        .weight(1.1f)
                        .fillMaxSize()
                ) {
                    AsyncImage(
                        modifier = Modifier.fillMaxSize(),
                        model = ImageRequest
                            .Builder(LocalContext.current)
                            .data(tourInfo.images[0])
                            .crossfade(true)
                            .build(),
                        contentDescription = "Image",
                        contentScale = ContentScale.Crop
                    )

                    Box(
                        modifier = Modifier
                            .padding(start = 2.dp, top = 2.dp)
                            .align(Alignment.TopStart),
                        contentAlignment = Alignment.Center
                    ) {
                        Box(
                            modifier = Modifier
                                .height(50.dp)
                                .width(50.dp)
                                .background(Color.Red, shape = CircleShape)
                                .padding(2.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = "Bonanza Offer\n ${context.getString(R.string.Rs)}",
                                textAlign = TextAlign.Center,
                                fontSize = 9.sp
                            )
                        }
                    }

                    Column(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .padding(top = 2.dp, end = 4.dp),
                        horizontalAlignment = Alignment.End
                    ) {
                        Text(
                            text = ("${context.getString(R.string.tour_code)}").uppercase(),
                            textAlign = TextAlign.End,
                            color = Color.DarkGray,
                            fontSize = 10.sp,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.Bold,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )

                        Text(
                            text = "${tourInfo.tourCode}",
                            textAlign = TextAlign.End,
                            color = Color.DarkGray,
                            fontSize = 13.sp,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.Bold,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis
                        )
                    }


                    Row(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .padding(bottom = 2.dp, start = 4.dp)
                    ) {
                        Image(
                            modifier = Modifier
                                .width(20.dp)
                                .height(20.dp),
                            alignment = Alignment.Center,
                            painter = painterResource(R.drawable.ic_bed_white),
                            contentDescription = "Bed"
                        )

                        Image(
                            modifier = Modifier
                                .width(20.dp)
                                .height(20.dp),
                            alignment = Alignment.Center,
                            painter = painterResource(R.drawable.ic_airplane_white),
                            contentDescription = "Airplane"
                        )

                        Image(
                            modifier = Modifier
                                .width(20.dp)
                                .height(20.dp),
                            alignment = Alignment.Center,
                            painter = painterResource(R.drawable.ic_car_white),
                            contentDescription = "Car"
                        )
                    }
                }

                Column(
                    Modifier
                        .padding(4.dp)
                        .weight(2f)
                        .fillMaxSize()
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = (tourInfo.tourName ?: context.getString(R.string.no_data_found)).uppercase(),
                        textAlign = TextAlign.Start,
                        color = Color.DarkGray,
                        fontSize = 17.sp,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Bold,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis
                    )

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.LightGray)
                    ) {
                        Row(
                            modifier = Modifier.weight(1.1f)
                        ) {
                            Column(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(end = 1.dp, bottom = 1.dp)
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .background(Color.White),
                                    verticalArrangement = Arrangement.Center,
                                    horizontalAlignment = Alignment.CenterHorizontally
                                ) {
                                    Text(
                                        modifier = Modifier,
                                        text = tourInfo.tmDays.toString(),
                                        textAlign = TextAlign.Center,
                                        color = Color.Gray,
                                        fontSize = 20.sp,
                                        fontStyle = FontStyle.Normal,
                                        fontWeight = FontWeight.Bold,
                                    )

                                    Text(
                                        modifier = Modifier,
                                        text = context.getString(R.string.nights),
                                        textAlign = TextAlign.Center,
                                        color = Color.DarkGray,
                                        fontSize = 11.sp,
                                        fontStyle = FontStyle.Normal
                                    )
                                }
                            }

                            Column(
                                modifier = Modifier
                                    .weight(2f)
                                    .padding(bottom = 1.dp)
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .background(Color.White),
                                    verticalArrangement = Arrangement.Center
                                ) {
                                    Row(
                                        modifier = Modifier.padding(start = 12.dp),
                                        horizontalArrangement = Arrangement.Center,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            modifier = Modifier,
                                            text = "Joining",
                                            textAlign = TextAlign.Center,
                                            color = Color.LightGray,
                                            fontSize = 12.sp,
                                            fontStyle = FontStyle.Normal,
                                            fontWeight = FontWeight.Bold
                                        )

                                        Spacer(modifier = Modifier.width(4.dp))

                                        Image(
                                            modifier = Modifier
                                                .width(9.dp)
                                                .height(9.dp),
                                            alignment = Alignment.Center,
                                            painter = painterResource(R.drawable.arrow_left),
                                            contentDescription = "Arrow Back"
                                        )

                                        Spacer(modifier = Modifier.width(4.dp))

                                        Text(
                                            modifier = Modifier,
                                            text = tourInfo.startCity ?: context.getString(R.string.no_data_found),
                                            textAlign = TextAlign.Center,
                                            color = Color.Green,
                                            fontSize = 12.sp,
                                            fontStyle = FontStyle.Normal,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }

                                    Row(
                                        modifier = Modifier.padding(start = 12.dp),
                                        horizontalArrangement = Arrangement.Center,
                                        verticalAlignment = Alignment.CenterVertically
                                    ) {
                                        Text(
                                            modifier = Modifier,
                                            text = "Leaving",
                                            textAlign = TextAlign.Center,
                                            color = Color.LightGray,
                                            fontSize = 12.sp,
                                            fontStyle = FontStyle.Normal,
                                            fontWeight = FontWeight.Bold
                                        )

                                        Spacer(modifier = Modifier.width(4.dp))

                                        Image(
                                            modifier = Modifier
                                                .width(9.dp)
                                                .height(9.dp),
                                            alignment = Alignment.Center,
                                            painter = painterResource(R.drawable.arrow_right),
                                            contentDescription = "Arrow Back"
                                        )

                                        Spacer(modifier = Modifier.width(4.dp))

                                        Text(
                                            modifier = Modifier,
                                            text = tourInfo.endCity ?: context.getString(R.string.no_data_found),
                                            textAlign = TextAlign.Center,
                                            color = Color.Red,
                                            fontSize = 12.sp,
                                            fontStyle = FontStyle.Normal,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                }
                            }
                        }

                        Row(
                            modifier = Modifier.weight(2f)
                        ) {
                            Column(
                                modifier = Modifier
                                    .weight(1f)
                                    .padding(end = 1.dp)
                            ) {
                                Column(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .background(Color.White)
                                ) {
                                    Column(
                                        modifier = Modifier
                                            .weight(1f)
                                            .fillMaxSize(),
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(
                                            modifier = Modifier,
                                            text = tourInfo.totalCity.toString(),
                                            textAlign = TextAlign.Center,
                                            color = Color.Gray,
                                            fontSize = 20.sp,
                                            fontStyle = FontStyle.Normal,
                                            fontWeight = FontWeight.Bold,
                                        )

                                        Text(
                                            modifier = Modifier,
                                            text = context.getString(R.string.countries),
                                            textAlign = TextAlign.Center,
                                            color = Color.DarkGray,
                                            fontSize = 11.sp,
                                            fontStyle = FontStyle.Normal
                                        )
                                    }

                                    Box(
                                        modifier = Modifier
                                            .height(1.dp)
                                            .fillMaxWidth()
                                            .padding(start = 5.dp, end = 6.dp)
                                    ) {
                                        Box(
                                            modifier = Modifier
                                                .fillMaxSize()
                                                .background(color = Color.LightGray)
                                        )
                                    }

                                    Column(
                                        modifier = Modifier
                                            .weight(1f)
                                            .fillMaxSize(),
                                        verticalArrangement = Arrangement.Center,
                                        horizontalAlignment = Alignment.CenterHorizontally
                                    ) {
                                        Text(
                                            modifier = Modifier,
                                            text = tourInfo.totalCity.toString(),
                                            textAlign = TextAlign.Center,
                                            color = Color.Gray,
                                            fontSize = 20.sp,
                                            fontStyle = FontStyle.Normal,
                                            fontWeight = FontWeight.Bold,
                                        )

                                        Text(
                                            modifier = Modifier,
                                            text = context.getString(R.string.cities),
                                            textAlign = TextAlign.Center,
                                            color = Color.DarkGray,
                                            fontSize = 11.sp,
                                            fontStyle = FontStyle.Normal
                                        )
                                    }
                                }
                            }

                            Column(
                                modifier = Modifier
                                    .weight(2f)
                                    .fillMaxHeight()
                                    .background(Color.White),
                                verticalArrangement = Arrangement.Center,
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    modifier = Modifier,
                                    text = "${context.getString(R.string.all_inclusive_price)}",
                                    textAlign = TextAlign.Center,
                                    color = Color.Gray,
                                    fontSize = 10.sp,
                                    fontStyle = FontStyle.Normal,
                                )

                                Text(
                                    modifier = Modifier,
                                    text = "${context.getString(R.string.Rs)} ${tourInfo.generatedCost2Day.toString()}*",
                                    textAlign = TextAlign.Center,
                                    color = Color.Gray,
                                    fontSize = 14.sp,
                                    fontStyle = FontStyle.Normal,
                                    fontWeight = FontWeight.Bold,
                                    style = TextStyle(textDecoration = TextDecoration.LineThrough)
                                )

                                Text(
                                    modifier = Modifier,
                                    text = "${context.getString(R.string.Rs)} ${tourInfo.generatedNetCost.toString()}*",
                                    textAlign = TextAlign.Center,
                                    color = Color.Red,
                                    fontSize = 16.sp,
                                    fontStyle = FontStyle.Normal,
                                    fontWeight = FontWeight.Bold
                                )

                                Button(
                                    onClick = {},
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(start = 10.dp, end = 10.dp),
                                    enabled = true,
                                    shape = RoundedCornerShape(6.dp),
                                    colors = ButtonDefaults.buttonColors(Color.Red)
                                ) {
                                    Text(
                                        modifier = Modifier,
                                        text = ("YOU SAVE ${context.getString(R.string.Rs)}${((tourInfo.generatedCost2Day ?: 0) - (tourInfo.generatedNetCost ?: 0))}"),
                                        textAlign = TextAlign.Center,
                                        color = Color.White,
                                        fontSize = 10.sp,
                                        fontStyle = FontStyle.Normal,
                                        fontWeight = FontWeight.Bold,
                                        maxLines = 1,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun preview() {
    //ToursInfoScreen(Tours())
}