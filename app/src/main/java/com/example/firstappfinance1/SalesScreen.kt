package com.example.firstappfinance1

import android.content.ClipData.Item
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstappfinance1.ui.theme.CustomCyan
import com.example.firstappfinance1.ui.theme.CustomDarkGray
import com.example.firstappfinance1.ui.theme.CustomLightGreen
import com.example.firstappfinance1.ui.theme.CustomLightOrange
import com.example.firstappfinance1.ui.theme.CustomOrange

fun Column(modifier: Modifier) {

}

@Composable
fun SalesScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(CustomDarkGray, CustomLightGreen)
                )
            )
            .padding(25.dp)

    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = {}) {
                Icon(
                    painter = painterResource(R.drawable.more), contentDescription = "more",
                    tint = Color.White,
                    modifier = Modifier.size(30.dp)
                )

            }
            Box(
                modifier = Modifier
                    .size(50.dp)
                    .border(
                        width = 1.dp,
                        color = CustomOrange,
                        shape = RoundedCornerShape(20f)
                    ), contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(R.drawable.david),
                    contentDescription = "Profile picture",
                    modifier = Modifier
                        .clip(RoundedCornerShape(5.dp))
                        .size(40.dp)
                )
            }
        }
        LazyRow(
            modifier = Modifier.height(250.dp),
            verticalAlignment = Alignment.Bottom
        ) {
            items(year2020Sals) { item ->
                singleBar(
                    monthelySalesData = item
                )
                Spacer(modifier = Modifier.width(15.dp))
            }
        }
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp),
            text = "Sales revenue",
            fontSize = 26.sp,
            color = Color.White,
            fontFamily = FontFamily(Font(R.font.ubuntu))

        )
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(modifier = Modifier.weight(1f)) {
                infoCard(cardHeight = 130.dp,
                    icon = painterResource(id = R.drawable.ic_sales),
                    mainText = "230k",
                    subText = "Sales"
                )
                Spacer(modifier = Modifier.height(20.dp))
                infoCard(cardHeight = 180.dp,
                    icon = painterResource(id = R.drawable.ic_wallet),
                    mainText = "1.42k",
                    subText = "Products")
            }
            Spacer(modifier = Modifier.width(20.dp))
            Column(modifier = Modifier.weight(1f)) {
                infoCard(cardHeight = 150.dp,
                    icon = painterResource(id = R.drawable.ic_user),
                    mainText = "8.549k",
                    subText = "Customers"
                )
                Spacer(modifier = Modifier.height(20.dp))
                infoCard(cardHeight = 200.dp,
                    icon = painterResource(id = R.drawable.ic_chart),
                    mainText = "$9745",
                    subText = "Revenue")
            }
        }
    }

}

@Composable
fun infoCard(
    cardHeight: Dp,
    icon : Painter,
    mainText:String,
    subText:String

) {

    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(30.dp))
            .fillMaxWidth()
            .height(cardHeight)
            .background(Color.White.copy(alpha = 0.1f)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Icon(
                painter = icon,
                contentDescription = mainText,
                modifier = Modifier.size(25.dp),
                tint = Color.White
            )
            Text(
                text = mainText,
                fontSize = 30.sp,
                fontFamily = FontFamily(Font(R.font.ubuntu)),
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.padding(vertical =10.dp)


            )
            Text(
                text = subText,
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.ubuntu)),
                fontWeight = FontWeight.Bold,
                color = Color.White


            )
        }
    }

}


data class MonthelySalesData(
    val month: String,
    val salesInThousands: Int,

    )

val year2020Sals = mutableListOf(
    MonthelySalesData(month = "Jan", salesInThousands = 25),
    MonthelySalesData(month = "Feb", salesInThousands = 45),
    MonthelySalesData(month = "Mar", salesInThousands = 44),
    MonthelySalesData(month = "Apr", salesInThousands = 85),
    MonthelySalesData(month = "May", salesInThousands = 28),
    MonthelySalesData(month = "June", salesInThousands = 23),
    MonthelySalesData(month = "July", salesInThousands = 43),
    MonthelySalesData(month = "Aug", salesInThousands = 53),
    MonthelySalesData(month = "Sep", salesInThousands = 73),
    MonthelySalesData(month = "Nov", salesInThousands = 70),
    MonthelySalesData(month = "Dec", salesInThousands = 40),
)

@Composable
fun singleBar(monthelySalesData: MonthelySalesData) {
    val largeSalesView = year2020Sals.maxOf { it.salesInThousands }

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = "${monthelySalesData.salesInThousands} k",
            color = Color.White,
            fontFamily = FontFamily(Font(R.font.ubuntu))

        )
        Spacer(modifier = Modifier.height(15.dp))
        Box(
            modifier = Modifier
                .clip(
                    RoundedCornerShape(
                        topStart = 10.dp,
                        topEnd = 10.dp
                    )
                )
                .background(
                    if (year2020Sals.indexOf(monthelySalesData) % 2 == 0) {
                        CustomLightOrange
                    } else CustomCyan
                )
                .width(40.dp)
                .height(
                    (200 * monthelySalesData.salesInThousands / largeSalesView).dp
                )
        ) {

        }
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "${monthelySalesData.month}",
            color = Color.White,
            fontFamily = FontFamily(Font(R.font.ubuntu))
        )

    }

}

@Preview
@Composable
fun SalesScreenPrev() {
    SalesScreen()
}