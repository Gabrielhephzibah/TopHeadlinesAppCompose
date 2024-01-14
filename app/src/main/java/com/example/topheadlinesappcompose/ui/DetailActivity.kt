package com.example.topheadlinesappcompose.ui

import androidx.activity.ComponentActivity


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