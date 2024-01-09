package com.example.topheadlinesappcompose.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.topheadlinesappcompose.R
import com.example.topheadlinesappcompose.domain.model.TopHeadlinesItem
import com.example.topheadlinesappcompose.ui.theme.nunitoFontFamilyLight
import com.example.topheadlinesappcompose.ui.theme.tieneFontFamily
import com.example.topheadlinesappcompose.ui.ui.theme.TopHeadlinesAppComposeTheme

class DetailActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        val dataIntent = intent
//        setContent {
//            TopHeadlinesAppComposeTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
//                    TopHeadLinesDetails(intent = dataIntent)
//                }
//            }
//        }
//    }
}

//@OptIn(ExperimentalGlideComposeApi::class)
//@Composable
//fun TopHeadLinesDetails(modifier: Modifier = Modifier, intent: Intent) {
//    val data = intent.getParcelableExtra<TopHeadlinesItem?>("data")
//    println("DATA:: $data")
//    Column {
//        GlideImage(
//            model = data?.imageUrl,
//            contentDescription = "background Image",
//            contentScale = ContentScale.FillBounds,
//            modifier = Modifier
//                .height(200.dp)
//                .fillMaxWidth()
//
//        )
////        Image(
////            painter = painterResource(
////                id = R.drawable.wall
////            ),
////            contentScale = ContentScale.FillBounds,
////            contentDescription = "image",
////            modifier = Modifier
////                .height(200.dp)
////                .fillMaxWidth()
////        )
//        Column(
//            modifier =
//            Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 20.dp)
//        ) {
//            Text(
//                text = data?.title.toString(),
//                fontSize = 20.sp,
//                fontFamily = FontFamily.SansSerif,
//                fontWeight = FontWeight.Bold,
//                modifier = Modifier.padding(vertical = 20.dp)
//            )
//
//            Text(
//                text = data?.description.toString(),
//                fontSize = 15.sp,
//                fontStyle = FontStyle.Italic,
//                fontFamily = nunitoFontFamilyLight
//            )
//            Text(text = data?.content.toString(),
//                modifier = Modifier.padding(vertical = 15.dp),
//                fontSize = 15.sp,
//                fontFamily = tieneFontFamily
//                )
//        }
//
//    }
//}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview2() {
//    //TopHeadLinesDetails()
//}