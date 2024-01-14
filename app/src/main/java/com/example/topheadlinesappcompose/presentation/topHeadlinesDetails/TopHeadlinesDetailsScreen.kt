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
fun TopHeadlinesDetailsScreen(navController:NavController,
                              title: String?,
                              description: String?,
                              imageUrl: String?,
                              content: String?) {
   // val dataIntent = intent
    TopHeadLinesDetails(title, description, imageUrl, content)
    println("Zibah:::Data::$title $imageUrl")
//    val backStackEntry = navController.previousBackStackEntry
//    println("Zibah:: BACK $backStackEntry")

}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun TopHeadLinesDetails(title: String?,
                        description: String?,
                        imageUrl: String?,
                        content: String?) {

    val decodeContent = String(Base64.getUrlDecoder().decode(content))
    //val getData  = navController.previousBackStackEntry?.arguments?.getParcelable("data")
//    val data = remember {
//        mutableStateOf(navController.previousBackStackEntry?.arguments?.getParcelable<TopHeadlinesItem>("data")!!)
//    }
   // println("Zibah:::Data::$getData")
//    val getData  = navController.previousBackStackEntry?.savedStateHandle?.get<DestinationScreenArgument>(
//        "detailArgument"
//    )
   // val data = intent.getParcelableExtra<TopHeadlinesItem?>("data")
    //println("DATA:: $data")
    Column {
        GlideImage(
            model = imageUrl,
            contentDescription = "background Image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .height(200.dp)
                .fillMaxWidth()

        )
//        Image(
//            painter = painterResource(
//                id = R.drawable.wall
//            ),
//            contentScale = ContentScale.FillBounds,
//            contentDescription = "image",
//            modifier = Modifier
//                .height(200.dp)
//                .fillMaxWidth()
//        )
        Column(
            modifier =
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Text(
                text =  title.toString(),
                fontSize = 20.sp,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 20.dp)
            )

            Text(
                text =  description.toString(),//data?.description.toString(),
                fontSize = 15.sp,
                fontStyle = FontStyle.Italic,
                fontFamily = nunitoFontFamilyLight
            )
            Text(text =  decodeContent, //data?.content.toString(),
                modifier = Modifier.padding(vertical = 15.dp),
                fontSize = 15.sp,
                fontFamily = tieneFontFamily
            )
        }

    }
}