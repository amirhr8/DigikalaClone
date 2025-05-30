package com.example.digikalaapp.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.digikalaapp.R
import com.example.digikalaapp.data.model.home.StoreProduct
import com.example.digikalaapp.ui.theme.DarkCyan
import com.example.digikalaapp.ui.theme.DigikalaDarkRed
import com.example.digikalaapp.ui.theme.DigikalaLightRed
import com.example.digikalaapp.ui.theme.darkText
import com.example.digikalaapp.ui.theme.extraSmall
import com.example.digikalaapp.ui.theme.semiDarkText
import com.example.digikalaapp.ui.theme.spacing
import com.example.digikalaapp.util.DigitHelper.applyDiscount
import com.example.digikalaapp.util.DigitHelper.digitByLocate
import com.example.digikalaapp.util.DigitHelper.digitByLocateAndSeparator
import com.example.digikalaapp.util.DigitHelper.digitBySeparator

@Composable
fun MostDiscountedCard(item: StoreProduct) {

    Card(
        modifier = Modifier
            .fillMaxWidth(0.5f), elevation = 1.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = MaterialTheme.spacing.semiLarge)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = MaterialTheme.spacing.extraSmall)
            ) {


                Image(
                    painter = rememberAsyncImagePainter(item.image),
                    contentDescription = "",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(130.dp),
                    contentScale = ContentScale.Fit
                )
            }

            Spacer(modifier = Modifier.height(10.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = MaterialTheme.spacing.small)
            ) {

                Text(
                    text =
                    item.name,
                    modifier = Modifier
                        .fillMaxSize()
                        .height(48.dp)
                        .padding(horizontal = MaterialTheme.spacing.small),
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colors.darkText,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
            }



            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = MaterialTheme.spacing.extraSmall),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Start
            ) {

                Icon(
                    painter = painterResource(R.drawable.in_stock),
                    contentDescription = "",
                    modifier = Modifier
                        .size(22.dp)
                        .padding(2.dp),
                    tint = MaterialTheme.colors.DarkCyan
                )

                Text(
                    text =
                    item.seller,
                    style = MaterialTheme.typography.extraSmall,
                    fontWeight = FontWeight.SemiBold,
                    color = MaterialTheme.colors.semiDarkText
                )

            }
            Spacer(modifier = Modifier.height(10.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(MaterialTheme.spacing.small),
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Box(
                    modifier = Modifier
                        .width(40.dp)
                        .height(24.dp)
                        .background(
                            MaterialTheme.colors.DigikalaDarkRed,
                            shape = CircleShape
                        )
                        .wrapContentWidth(Alignment.CenterHorizontally)
                        .wrapContentHeight(Alignment.CenterVertically)
                ) {

                    Text(
                        text =
                        "${digitByLocate(item.discountPercent.toString())}%",
                        style = MaterialTheme.typography.h6,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }

                Column {
                    Row {
                        Text(
                            text =
                            digitBySeparator(
                                applyDiscount(
                                    item.price,
                                    item.discountPercent
                                ).toString()
                            ),
                            style = MaterialTheme.typography.body2,
                            fontWeight = FontWeight.SemiBold,
                        )

                        Image(
                            painter = painterResource(id = R.drawable.toman),
                            contentDescription = "",
                            modifier = Modifier
                                .size(MaterialTheme.spacing.semiLarge)
                                .padding(horizontal = MaterialTheme.spacing.extraSmall)
                        )
                    }

                    Text(
                        text =
                        digitByLocateAndSeparator(item.price.toString()),
                        style = MaterialTheme.typography.body2,
                        color = Color.LightGray,
                        textDecoration = TextDecoration.LineThrough
                    )
                }
            }
        }


    }

}