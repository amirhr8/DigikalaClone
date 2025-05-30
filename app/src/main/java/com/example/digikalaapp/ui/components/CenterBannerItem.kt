package com.example.digikalaapp.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.digikalaapp.R
import com.example.digikalaapp.ui.theme.darkText
import com.example.digikalaapp.ui.theme.roundedShape
import com.example.digikalaapp.ui.theme.spacing

@Composable
fun CenterBannerItem(imagUrl: String) {

    Card(
        shape = MaterialTheme.roundedShape.semiMedium,
        modifier = Modifier
            .fillMaxWidth()
            .height(170.dp)
            .padding(MaterialTheme.spacing.semiMedium)

    )
    {
        Image(
            modifier = Modifier
                .fillMaxSize(),
            painter = rememberAsyncImagePainter(imagUrl),
            contentDescription = "",
            contentScale = ContentScale.FillBounds

        )
    }
}
