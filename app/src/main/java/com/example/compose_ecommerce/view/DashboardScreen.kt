package com.example.compose_ecommerce.view

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose_ecommerce.R
import com.example.compose_ecommerce.ui.theme.cottonBall
import com.example.compose_ecommerce.ui.theme.paledark
import com.example.compose_ecommerce.ui.theme.texttitlewhite

@Preview(showBackground = true)
@Composable
fun DashboardScreen() {
    val itemList = listOf("Chairs", "Sofas", "Beds", "Tables")

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .background(cottonBall)
    ) {
        Column(modifier = Modifier.verticalScroll(rememberScrollState())) {
            Spacer(modifier = Modifier.padding(5.dp))
            Header()
            Spacer(modifier = Modifier.padding(25.dp))
            CategoryChairs(itemList)
        }
    }


}


@Composable
fun Header() {
    Row(
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        paledark,
                        fontWeight = FontWeight.Bold
                    )
                ) {
                    append("Our ")
                }
                withStyle(
                    style = SpanStyle(
                        paledark
                    )
                ) {
                    append("Products")
                }
            },
            style = MaterialTheme.typography.subtitle1,
            modifier = Modifier,
            fontSize = 24.sp

        )

        Card(
            modifier = Modifier.width(50.dp),
            elevation = 4.dp,
            shape = RoundedCornerShape(8.dp)
        ) {
            IconButton(onClick = { /**Here gonna put search functionality*/ }) {
                Icon(
                    imageVector = Icons.Outlined.Search,
                    contentDescription = ""
                )

            }
        }
    }
}

@Composable
fun CategoryChairs(itemList: List<String>) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        items(itemList.size) { item ->
            Box(
                modifier = Modifier.border(
                    color = if (item == 0) paledark else Color.Transparent,
                    width = 2.dp,
                    shape = RoundedCornerShape(24.dp)
                )
            ) {
                Text(
                    modifier = Modifier.padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 8.dp,
                        bottom = 8.dp
                    ),
                    text = itemList[item],
                    color = if (item == 0) paledark else Color.LightGray
                )

                Spacer(modifier = Modifier.padding(8.dp))
            }
        }
    }

    Spacer(modifier = Modifier.padding(10.dp))

    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            ChairsItem(
                imagePainter = painterResource(id = R.drawable.furniture_1),
                title = "Matteo\n" +
                        "Armchair",
                price = "$240",

                )
        }

        item {
            ChairsItem(
                imagePainter = painterResource(id = R.drawable.furniture_2),
                title = "Araceli\n" +
                        "Armchair",
                price = "$240"
            )
        }

        item {
            ChairsItem(
                imagePainter = painterResource(id = R.drawable.furniture_3),
                title = "Primose\n" +
                        "Armchair",
                price = "$240"
            )
        }

    }
}

@Composable
fun ChairsItem(
    imagePainter: Painter,
    title: String = "",
    price: String = ""
) {
    Card(
        modifier = Modifier
            .width(200.dp)
            .clickable {  /*Here we will navigate to the details screen*/ },
        elevation = 10.dp,
        shape = RoundedCornerShape(20.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Image(
                painter = imagePainter,
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f),
                contentScale = ContentScale.Fit
            )
            Text(text = title, color = texttitlewhite)
            Text(text = price, fontWeight = FontWeight.Bold)
        }

    }
}