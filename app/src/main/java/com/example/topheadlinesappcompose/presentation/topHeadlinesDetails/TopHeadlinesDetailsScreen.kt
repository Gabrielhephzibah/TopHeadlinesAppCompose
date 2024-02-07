package com.example.topheadlinesappcompose.presentation.topHeadlinesDetails

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.topheadlinesappcompose.R
import com.example.topheadlinesappcompose.domain.model.TopHeadlinesItem
import com.example.topheadlinesappcompose.ui.theme.nunitoFontFamilyLight
import com.example.topheadlinesappcompose.ui.theme.tieneFontFamily
import java.util.Base64

@Composable
fun TopHeadlinesDetailsScreen(topHeadlinesItem: TopHeadlinesItem?) {
    TopHeadLinesDetails(topHeadlinesItem)
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun TopHeadLinesDetails(topHeadlinesItem: TopHeadlinesItem?) {
    Column {
        GlideImage(
            model = topHeadlinesItem?.imageUrl,
            contentDescription = "background Image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()

        )
        Column(
            modifier =
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Text(
                text =  topHeadlinesItem?.title.toString(),
                fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 20.dp)
            )

            Text(
                text =  topHeadlinesItem?.description.toString(),
                fontSize = 15.sp,
                fontStyle = FontStyle.Italic,
                fontFamily = nunitoFontFamilyLight
            )
            Text(text =  topHeadlinesItem?.content.toString(),
                modifier = Modifier.padding(vertical = 15.dp),
                fontSize = 15.sp,
                fontFamily = tieneFontFamily
            )
        }

    }
}