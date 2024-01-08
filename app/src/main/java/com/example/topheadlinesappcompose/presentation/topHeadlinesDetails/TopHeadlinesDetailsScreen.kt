package com.example.topheadlinesappcompose.presentation.topHeadlinesDetails

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.topheadlinesappcompose.R
import com.example.topheadlinesappcompose.domain.model.TopHeadlinesItem
import com.example.topheadlinesappcompose.ui.theme.nunitoFontFamilyLight
import com.example.topheadlinesappcompose.ui.theme.tieneFontFamily

@Composable
fun TopHeadlinesDetailsScreen() {
   // val dataIntent = intent
    TopHeadLinesDetails()

}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun TopHeadLinesDetails(modifier: Modifier = Modifier) {
   // val data = intent.getParcelableExtra<TopHeadlinesItem?>("data")
    //println("DATA:: $data")
    Column {
//        GlideImage(
//            model = data?.imageUrl,
//            contentDescription = "background Image",
//            contentScale = ContentScale.FillBounds,
//            modifier = Modifier
//                .height(200.dp)
//                .fillMaxWidth()
//
//        )
        Image(
            painter = painterResource(
                id = R.drawable.wall
            ),
            contentScale = ContentScale.FillBounds,
            contentDescription = "image",
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
                text =  "Headlines Title",//data?.title.toString(),
                fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 20.dp)
            )

            Text(
                text =  "Headlines Description",//data?.description.toString(),
                fontSize = 15.sp,
                fontStyle = FontStyle.Italic,
                fontFamily = nunitoFontFamilyLight
            )
            Text(text =  "Headlines Content", //data?.content.toString(),
                modifier = Modifier.padding(vertical = 15.dp),
                fontSize = 15.sp,
                fontFamily = tieneFontFamily
            )
        }

    }
}