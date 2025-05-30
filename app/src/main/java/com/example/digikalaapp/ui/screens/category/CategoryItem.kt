package com.example.digikalaapp.ui.screens.category

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import com.example.digikalaapp.R
import com.example.digikalaapp.data.model.category.Sub
import com.example.digikalaapp.ui.theme.DigikalaLightRed
import com.example.digikalaapp.ui.theme.LightCyan
import com.example.digikalaapp.ui.theme.extraSmall
import com.example.digikalaapp.ui.theme.spacing

@Composable
fun CategoryItem(
    title: String,
    subList: List<Sub>
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                top = MaterialTheme.spacing.medium,
                bottom = MaterialTheme.spacing.small,
                start = MaterialTheme.spacing.small,
                end = MaterialTheme.spacing.small

            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.h3,
            fontWeight = FontWeight.Bold,
        )

        Text(
            text =
            stringResource(id = R.string.see_all),
            modifier = Modifier.padding(start = MaterialTheme.spacing.small),
            style = MaterialTheme.typography.h5,
            fontWeight = FontWeight.SemiBold,
            color = MaterialTheme.colors.LightCyan
        )
    }

    LazyRow (){
        items(subList){ list->
            SubCategoryItem(list)
        }
    }
}