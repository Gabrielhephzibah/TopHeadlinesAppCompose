package com.example.topheadlinesappcompose.presentation.topHeadlinesList

import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.topheadlinesappcompose.domain.model.TopHeadlinesItem
import com.example.topheadlinesappcompose.ui.theme.nunitoFontFamilyBold
import com.example.topheadlinesappcompose.utils.Resource
import com.example.topheadlinesappcompose.utils.extensions.formatDate

@Composable
fun TopHeadlinesListScreen(
    onItemClicked: (TopHeadlinesItem?) -> Unit
) {
    GetTopHeadlines(
        onItemClicked
    )
}


@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun TopHeadLinesItemComposable(topHeadlinesItem: TopHeadlinesItem?, onItemClicked: (TopHeadlinesItem?) -> Unit){
    val context = LocalContext.current
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 7.dp, vertical = 10.dp)
            .clickable {
                onItemClicked(topHeadlinesItem)
            },
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        shape = RoundedCornerShape(corner = CornerSize(5.dp))


    ) {
        Row {
            Box(modifier = Modifier.fillMaxWidth(),


                ){
                GlideImage(
                    model = topHeadlinesItem?.imageUrl,
                    contentDescription = "background Image",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .height(200.dp)
                        .fillMaxWidth()

                )
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxWidth()
                        .align(Alignment.BottomEnd),
                    verticalArrangement = Arrangement.Bottom,
                ) {
                    Text(text = topHeadlinesItem?.title.toString(),
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = nunitoFontFamilyBold
                    )
                    Spacer(modifier = Modifier.size(5.dp))
                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = topHeadlinesItem?.publishedAt.toString().formatDate(),
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontFamily = nunitoFontFamilyBold,
                        fontSize = 12.sp,
                        textAlign = TextAlign.End
                    )
                }
            }

        }


    }


}

@Composable
fun TopHeadLineList(topHeadlinesItem: List<TopHeadlinesItem>?, onItemClicked: (TopHeadlinesItem?)-> Unit){
    LazyColumn(modifier = Modifier.fillMaxSize())
    {
        topHeadlinesItem?.size?.let {
            items(it) { i ->
                TopHeadLinesItemComposable(
                    topHeadlinesItem = topHeadlinesItem[i],
                    onItemClicked = onItemClicked
                )
            }
        }
    }
}

@Composable
fun GetTopHeadlines(onItemClicked: (TopHeadlinesItem?) -> Unit) {
    val topViewModel : TopHeadlineViewModel = hiltViewModel()
//    val lifecycle = LocalLifecycleOwner.current
//    LaunchedEffect(Unit){
//        lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED){
//            topViewModel.getTopHeadlines("bbc-news").collect{
//                when(it){
//                    is Resource.Error -> println("ERROR:: ${it.error}")
//                    is Resource.Success -> println("SUCCESS::: ${it.data}")
//                }
//            }
//        }
//    }
//    val mutableState = remember {
//        TopHeadlinesResponse()
//    }


    val response by topViewModel.getTopHeadlines.collectAsStateWithLifecycle(Resource.Loading)
    when(response){
        is Resource.Error -> {
            ShowError()
        }
        Resource.Loading -> {
           LoadProgressBar()
        }
        is Resource.Success -> {
            println("SUCCESS::: ${response.data}")
            val data = response.data
            TopHeadLineList(topHeadlinesItem = data, onItemClicked = onItemClicked)
        }
    }
}

@Composable
fun LoadProgressBar(){
//    Column(
//        modifier = Modifier.fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        CircularProgressIndicator(
//            color = Color.Black,
//            trackColor = MaterialTheme.colorScheme.surfaceVariant,
//        )
//        //CircularProgressIndicator()
//    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        CircularProgressIndicator(
            color = Color.Black,
            trackColor = MaterialTheme.colorScheme.surfaceVariant,
        )
    }

}
@Composable
fun ShowError(){
   Column(
       modifier = Modifier.fillMaxSize(),
       horizontalAlignment = Alignment.CenterHorizontally,
       verticalArrangement = Arrangement.Center
   ) {
     Text(
         text = "Connection Error, please try again later",
         color = Color.Black,
         fontSize = 20.sp
     )
   }
}

@Preview
@Composable
fun TopHeadlinesListPreview(){
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        ShowError()
    }



}





