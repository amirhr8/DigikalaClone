package com.example.digikalaapp.ui.screens.basket

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.rememberAsyncImagePainter
import com.example.digikalaapp.R
import com.example.digikalaapp.data.model.basket.CartItem
import com.example.digikalaapp.ui.theme.DarkCyan
import com.example.digikalaapp.ui.theme.DigikalaLightGreen
import com.example.digikalaapp.ui.theme.DigikalaLightRed
import com.example.digikalaapp.ui.theme.darkText
import com.example.digikalaapp.ui.theme.digikalaRed
import com.example.digikalaapp.ui.theme.extraSmall
import com.example.digikalaapp.ui.theme.roundedShape
import com.example.digikalaapp.ui.theme.semiDarkText
import com.example.digikalaapp.ui.theme.spacing
import com.example.digikalaapp.ui.theme.veryExtraSmall
import com.example.digikalaapp.util.DigitHelper.digitByLocateAndSeparator
import com.example.digikalaapp.viewmodel.BasketViewModel

@Composable
fun CartItemCard(
    item: CartItem,
    viewModel: BasketViewModel = hiltViewModel()
) {

    val count = remember {
        mutableStateOf(item.count)
    }


    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = MaterialTheme.spacing.extraSmall)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(MaterialTheme.spacing.medium)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {


                Column {
                    Text(
                        text = stringResource(R.string.your_shopping_list),
                        style = MaterialTheme.typography.h4,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.darkText
                    )
                    Text(
                        text = "${digitByLocateAndSeparator(count.value.toString())}  کالا",
                        style = MaterialTheme.typography.h6,
                        color = Color.Gray
                    )

                }

                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "More Options",
                    tint = MaterialTheme.colors.darkText
                )
            }

            Spacer(modifier = Modifier.height(12.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = rememberAsyncImagePainter(item.image),
                    contentDescription = "cart item Photo",
                    modifier = Modifier
                        .width(130.dp)
                        .height(90.dp)
                        .weight(.3f),
                )

                Column(
                    modifier = Modifier
                        .weight(.7f)
                ) {
                    Text(
                        text = item.name,
                        style = MaterialTheme.typography.h6,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colors.darkText,
                        maxLines = 2,
                        modifier = Modifier
                            .padding(vertical = MaterialTheme.spacing.extraSmall)
                    )


                    DetailRow(
                        painterResource(id = R.drawable.warranty),
                        stringResource(id = R.string.warranty),
                        color = MaterialTheme.colors.darkText,
                        fontStyle = MaterialTheme.typography.extraSmall
                    )

                    DetailRow(
                        painterResource(id = R.drawable.store),
                        stringResource(id = R.string.digikala),
                        color = MaterialTheme.colors.darkText,
                        fontStyle = MaterialTheme.typography.extraSmall
                    )



                    Row {
                        Column(
                            modifier = Modifier
                                .width(16.dp)
                                .fillMaxHeight()
                                .padding(
                                    vertical = MaterialTheme.spacing.extraSmall,
                                ),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.in_stock),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(16.dp),
                                tint = MaterialTheme.colors.DarkCyan
                            )

                            Divider(
                                Modifier
                                    .width(2.dp)
                                    .height(16.dp)
                                    .alpha(0.6f),
                                color = Color.LightGray
                            )

                            Icon(
                                painter = painterResource(id = R.drawable.circle),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(10.dp)
                                    .padding(1.dp),
                                tint = MaterialTheme.colors.DarkCyan,
                            )

                            Divider(
                                Modifier
                                    .width(2.dp)
                                    .height(16.dp)
                                    .alpha(0.6f),
                                color = Color.LightGray
                            )

                            Icon(
                                painter = painterResource(id = R.drawable.circle),
                                contentDescription = "",
                                modifier = Modifier
                                    .size(10.dp)
                                    .padding(1.dp),
                                tint = MaterialTheme.colors.DarkCyan,
                            )


                        }

                        Column(Modifier.padding(horizontal = 8.dp)) {

                            Text(
                                text = item.seller,
                                style = MaterialTheme.typography.extraSmall,
                                fontWeight = FontWeight.SemiBold,
                                color = MaterialTheme.colors.semiDarkText,
                                modifier = Modifier
                                    .padding(vertical = MaterialTheme.spacing.extraSmall),
                            )

                            DetailRow(
                                painterResource(id = R.drawable.k1),
                                stringResource(id = R.string.digikala_send),
                                color = MaterialTheme.colors.DigikalaLightRed,
                                fontStyle = MaterialTheme.typography.veryExtraSmall
                            )

                            DetailRow(
                                painterResource(id = R.drawable.k2),
                                stringResource(id = R.string.fast_send),
                                color = MaterialTheme.colors.DigikalaLightGreen,
                                fontStyle = MaterialTheme.typography.veryExtraSmall
                            )

                        }
                    }


                }
            }

            Spacer(modifier = Modifier.height(MaterialTheme.spacing.semiLarge))

            Row(
                modifier = Modifier
                    .align(Alignment.Start),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Surface(
                    modifier = Modifier
                        .clip(MaterialTheme.roundedShape.semiSmall)
                        .border(
                            1.dp,
                            Color.LightGray.copy(0.6f),
                            MaterialTheme.roundedShape.semiSmall
                        )

                ) {

                    Row(
                        modifier = Modifier
                            .padding(
                                horizontal = MaterialTheme.spacing.small,
                                vertical = MaterialTheme.spacing.extraSmall
                            ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Icon(
                            painterResource(id = R.drawable.ic_increase_24),
                            contentDescription = "increase icon",
                            tint = MaterialTheme.colors.digikalaRed,
                            modifier = Modifier.clickable {
                                count.value++
                                viewModel.changeCartItemCount(item.itemId , count.value)
                            }
                        )

                        Text(
                            text = digitByLocateAndSeparator(count.value.toString()),
                            style = MaterialTheme.typography.body2,
                            fontWeight = FontWeight.SemiBold,
                            color = MaterialTheme.colors.digikalaRed,
                            modifier = Modifier
                                .padding(horizontal = MaterialTheme.spacing.medium)
                        )


                        if (count.value == 1) {
                            Icon(
                                painterResource(id = R.drawable.digi_trash),
                                contentDescription = "increase icon",
                                tint = MaterialTheme.colors.digikalaRed,
                                modifier = Modifier.clickable {
                                    viewModel.removeCartItem(item)
                                }
                            )
                        } else {
                            Icon(
                                painterResource(id = R.drawable.ic_decrease_24),
                                contentDescription = "increase icon",
                                tint = MaterialTheme.colors.digikalaRed,
                                modifier = Modifier.clickable {
                                    count.value--
                                    viewModel.changeCartItemCount(item.itemId , count.value)
                                }
                            )
                        }


                    }


                }


                Spacer(
                    modifier = Modifier
                        .padding(MaterialTheme.spacing.semiMedium)
                )

                Row {
                    Text(
                        text = digitByLocateAndSeparator(item.price.toString()),
                        style = MaterialTheme.typography.h3,
                        fontWeight = FontWeight.SemiBold,
                        color = MaterialTheme.colors.darkText,
                    )

                    Icon(
                        painter = painterResource(id = R.drawable.toman),
                        contentDescription = "",
                        modifier = Modifier
                            .size(24.dp)
                            .padding(MaterialTheme.spacing.extraSmall)
                    )
                }
            }

            Spacer(modifier = Modifier.height(MaterialTheme.spacing.semiLarge))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = stringResource(R.string.save_to_next_list),
                    fontWeight = FontWeight.Light,
                    style = MaterialTheme.typography.h6,
                    color = MaterialTheme.colors.DarkCyan
                )

                Icon(
                    imageVector = Icons.Filled.KeyboardArrowLeft,
                    contentDescription = "",
                    tint = MaterialTheme.colors.DarkCyan
                )
            }

        }
    }
}





@Composable
private fun DetailRow(
    icon: Painter,
    text: String,
    color: Color,
    fontStyle: TextStyle
) {
    Row(
        modifier = Modifier
            .padding(vertical = MaterialTheme.spacing.extraSmall),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Icon(
            painter = icon,
            contentDescription = "",
            modifier = Modifier.size(16.dp),
            tint = color,
        )

        Spacer(modifier = Modifier.width(MaterialTheme.spacing.small))

        Text(
            text = text,
            style = fontStyle,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colors.semiDarkText,

            )
    }
}