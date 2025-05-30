package com.example.digikalaapp.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.digikalaapp.R
import com.example.digikalaapp.ui.theme.DarkCyan
import com.example.digikalaapp.ui.theme.darkText
import com.example.digikalaapp.ui.theme.extraBoldNumber
import com.example.digikalaapp.ui.theme.spacing

@Composable
fun ProductHorizontalCard(name: String, id: String, imageUrl: String) {

    Row(
        modifier = Modifier
            .width(320.dp)
            .padding(bottom = MaterialTheme.spacing.extraSmall),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = rememberAsyncImagePainter(imageUrl),
            contentDescription = "",
            modifier = Modifier
                .weight(.3f)
                .fillMaxHeight()
        )

        Text(
            modifier = Modifier
                .weight(.1f)
                .padding(horizontal = MaterialTheme.spacing.small),
            text = id,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.extraBoldNumber,
            fontWeight = FontWeight.Black,
            color = MaterialTheme.colors.DarkCyan
        )

        Column(
            modifier = Modifier
                .weight(.6f)
                .fillMaxHeight()
                .padding(vertical = MaterialTheme.spacing.small)
        ) {
            Text(
                modifier = Modifier
                    .weight(.1f)
                    .padding(top = MaterialTheme.spacing.small),
                text = name,
                style = MaterialTheme.typography.body2,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.colors.darkText,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

        }


    }
}