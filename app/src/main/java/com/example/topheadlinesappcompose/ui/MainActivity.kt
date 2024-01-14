package com.example.topheadlinesappcompose.ui

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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
import androidx.navigation.NavArgument
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.findNavController
import androidx.navigation.navArgument
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.topheadlinesappcompose.domain.model.TopHeadlinesItem
import com.example.topheadlinesappcompose.presentation.navigation.TopHeadlinesScreens
import com.example.topheadlinesappcompose.presentation.topHeadlinesDetails.TopHeadlinesDetailsScreen
import com.example.topheadlinesappcompose.ui.theme.TopHeadlinesAppComposeTheme
import com.example.topheadlinesappcompose.ui.theme.nunitoFontFamilyBold
import com.example.topheadlinesappcompose.presentation.topHeadlinesList.TopHeadlineViewModel
import com.example.topheadlinesappcompose.presentation.topHeadlinesList.TopHeadlinesListScreen
import com.example.topheadlinesappcompose.utils.Resource
import com.example.topheadlinesappcompose.utils.extensions.formatDate
import dagger.hilt.android.AndroidEntryPoint
import java.util.Base64

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TopHeadlinesAppComposeTheme {
                val navController = rememberNavController()
                val backStackEntry by navController.currentBackStackEntryAsState()
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column(modifier = Modifier.fillMaxSize()) {
                        TopHeadlinesApp()
                       // TopAppBar(navController = navController)
//                        NavHost(
//                            navController = navController,
//                            startDestination = TopHeadlinesScreens.HeadLineList.name,
//                            enterTransition = {
//                                EnterTransition.None
//                            },
//                            exitTransition =  {
//                                ExitTransition.None
//                            },
//                            popEnterTransition = {
//                                EnterTransition.None
//                            },
//                            popExitTransition = {
//                                ExitTransition.None
//                            }
//                        ) {
//                            composable(TopHeadlinesScreens.HeadLineList.name) {
//                                TopHeadlinesListScreen(
//                                    onItemClicked = {
//                                        println("Zibah:::Navigated to next screen")
//                                        println("Zibah:::$it")
//                                        val encodedContent =  Base64.getUrlEncoder().encodeToString(it?.content?.toByteArray())
//                                        navController.navigate(
//                                            route = TopHeadlinesScreens.HeadLineDetails.name +
//                                                    "?${it?.title}" + "?${it?.description}"
//                                                    + "/$encodedContent"
//                                                    + "?${it?.imageUrl}",
////                                           argument = listOf(
////                                               navArgument("title") { type = NavType.StringType },
////                                               navArgument("description") { type = NavType.StringType },
////                                               navArgument("author") { type = NavType.StringType },
////
////                                           )
//                                        )
//                                    }
//                                )
//                            }
//                            composable(
//                                TopHeadlinesScreens.HeadLineDetails.name + "?{title}" + "?{description}"
//                                         + "/{content}"
//                                        + "?{imageUrl}",
//                                arguments = listOf(
//                                    navArgument("title") {
//                                        type = NavType.StringType
//                                        defaultValue = ""
//                                        nullable = true
//                                    },
//                                    navArgument("description") {
//                                        type = NavType.StringType
//                                        defaultValue = ""
//                                        nullable = true
//                                    },
//                                    navArgument("content") {
//                                        type = NavType.StringType
//                                        },
//                                    navArgument("imageUrl") {
//                                        type = NavType.StringType
//                                        defaultValue = ""
//                                        nullable = true
//                                    }
//                                )
//                            ) { navArgument ->
//                                val title = navArgument.arguments?.getString("title")
//                                val desc = navArgument.arguments?.getString("description")
//                                val content = navArgument.arguments?.getString("content")
//                                val imgUrl = navArgument.arguments?.getString("imageUrl")
//                                TopHeadlinesDetailsScreen(navController,
//                                    title,
//                                    desc,
//                                    imgUrl,
//                                    content
//                                )
//                            }
//                        }

                        //buttonClick()
                        //getTopHeadlines()
//                     val response = TopHeadlinesItem(
//                       "Birmingham sack Rooney after 15 games in charge",
//                       "Birmingham sack Rooney after 15 games in charge",
//                       "",
//                       "",
//                       "2024-01-02T12:22:23.4088451Z",
//                       "")
//                        val item = arrayListOf<TopHeadlinesItem>()
//                        while (item.size != 10){
//                            item.add(response)
//                        }
//                        TopHeadLineList(topHeadlinesItem = item)

                    }

                }
            }
        }
    }
}

@Composable
fun TopHeadlinesApp(navController: NavHostController = rememberNavController()) {
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
//    val currentScreen = TopHeadlinesScreens.valueOf(
//        backStackEntry?.destination?.route?: TopHeadlinesScreens.HeadLineList.name
//    )
    Scaffold(
        topBar = {
            TopAppBar(
                canNavigateBack = navController.previousBackStackEntry != null,
                navigateUp = { navController.navigateUp() }

            )
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = TopHeadlinesScreens.HeadLineList.name,
            enterTransition = {
                EnterTransition.None
            },
            exitTransition =  {
                ExitTransition.None
            },
            popEnterTransition = {
                EnterTransition.None
            },
            popExitTransition = {
                ExitTransition.None
            },
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(TopHeadlinesScreens.HeadLineList.name) {
                TopHeadlinesListScreen(
                    onItemClicked = {
                        println("Zibah:::Navigated to next screen")
                        println("Zibah:::$it")
                       // navController.currentBackStackEntry?.savedStateHandle?.set("data", it)
                        val encodedContent =  Base64.getUrlEncoder().encodeToString(it?.content?.toByteArray())
                        navController.navigate(
                            route = TopHeadlinesScreens.HeadLineDetails.name +
                                    "?${it?.title}" + "?${it?.description}"
                                    + "/$encodedContent"
                                    + "?${it?.imageUrl}",
//                                           argument = listOf(
//                                               navArgument("title") { type = NavType.StringType },
//                                               navArgument("description") { type = NavType.StringType },
//                                               navArgument("author") { type = NavType.StringType },
//
//                                           )
                        )
                    }
                )
            }
            composable(
                TopHeadlinesScreens.HeadLineDetails.name + "?{title}" + "?{description}"
                        + "/{content}"
                        + "?{imageUrl}",
                arguments = listOf(
                    navArgument("title") {
                        type = NavType.StringType
                        defaultValue = ""
                        nullable = true
                    },
                    navArgument("description") {
                        type = NavType.StringType
                        defaultValue = ""
                        nullable = true
                    },
                    navArgument("content") {
                        type = NavType.StringType
                    },
                    navArgument("imageUrl") {
                        type = NavType.StringType
                        defaultValue = ""
                        nullable = true
                    }
                )
            ) { navArgument ->
//                LaunchedEffect(key1 = navArgument){
//                    val result = navController.previousBackStackEntry.savedStateHandle.get<TopHeadlinesItem>(
//                        "data"
//                    )
//                }

                val title = navArgument.arguments?.getString("title")
                val desc = navArgument.arguments?.getString("description")
                val content = navArgument.arguments?.getString("content")
                val imgUrl = navArgument.arguments?.getString("imageUrl")
                TopHeadlinesDetailsScreen(navController,
                    title,
                    desc,
                    imgUrl,
                    content
                )
            }
        }



    }

//    val backStackEntry by navController.currentBackStackEntryAsState()
//    val currentScreen = TopHeadlinesScreens.valueOf(
//        backStackEntry?.destination?.route ?: TopHeadlinesScreens.HeadLineList.name
//    )
//    NavHost(navController = rememberNavController(), startDestination = "First"){
//        composable("First"){
//            FirstScreen()
//        }
//        composable("Second"){
//            SecondScreen()
//        }
//    }
}


//fun goToNextScreen(context: Context, topHeadlinesItem: TopHeadlinesItem?) {
//    val nextScreenIntent = Intent(context, DetailActivity::class.java)
//    nextScreenIntent.putExtra("data", topHeadlinesItem)
//    context.startActivity(nextScreenIntent)
//
//    //context.startActivity(Intent(context, DetailActivity::class.java))
//}
//@Composable
//fun buttonClick(){
//    val context = LocalContext.current
//    Button(onClick = {
//        goToNextScreen(context)
//    }) {
//        Text(text = "CLICK")
//
//    }
//}

//@Composable
//fun getTopHeadlines() {
// val topViewModel : TopHeadlineViewModel = hiltViewModel()
////    val lifecycle = LocalLifecycleOwner.current
////    LaunchedEffect(Unit){
////        lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED){
////            topViewModel.getTopHeadlines("bbc-news").collect{
////                when(it){
////                    is Resource.Error -> println("ERROR:: ${it.error}")
////                    is Resource.Success -> println("SUCCESS::: ${it.data}")
////                }
////            }
////        }
////    }
////    val mutableState = remember {
////        TopHeadlinesResponse()
////    }
//
//
//    val response by topViewModel.getTopHeadlines.collectAsStateWithLifecycle(Resource.Loading)
//    when(response){
//        is Resource.Error -> print("ERROR:::${response.error}")
//        Resource.Loading -> println("Loading")
//        is Resource.Success -> {
//            println("SUCCESS::: ${response.data}")
//            val data = response.data
//                TopHeadLineList(topHeadlinesItem = data)
//        }
//    }
//
//}
//@Composable
//fun TopHeadLineList(topHeadlinesItem: List<TopHeadlinesItem>?){
//    LazyColumn(modifier = Modifier.fillMaxSize())
//    {
//         items(10) {i ->
//             TopHeadLinesItemComposable(topHeadlinesItem = topHeadlinesItem?.get(i))
//
//         }
//    }
//
//}

//@OptIn(ExperimentalGlideComposeApi::class)
//@Composable
//fun TopHeadLinesItemComposable(topHeadlinesItem: TopHeadlinesItem?){
//    val context = LocalContext.current
//    Card(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(horizontal = 7.dp, vertical = 10.dp)
//            .clickable {
//                goToNextScreen(context, topHeadlinesItem)
//            },
//        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
//        colors = CardDefaults.cardColors(
//            containerColor = Color.White
//        ),
//        shape = RoundedCornerShape(corner = CornerSize(5.dp))
//
//
//    ) {
//   Row {
//       Box(modifier = Modifier.fillMaxWidth(),
//
//
//       ){
//           GlideImage(
//               model = topHeadlinesItem?.imageUrl,
//               contentDescription = "background Image",
//               contentScale = ContentScale.FillBounds,
//               modifier = Modifier
//                   .height(200.dp)
//                   .fillMaxWidth()
//
//               )
////           Image(
////               painter = painterResource(id = R.drawable.wall),
////               contentDescription = "background",
////               contentScale = ContentScale.FillBounds,
////               modifier = Modifier
////                   .height(200.dp)
////                   .fillMaxWidth()
////                   //.matchParentSize()
////           )
//           Column(
//               modifier = Modifier
//                   .padding(16.dp)
//                   .fillMaxWidth()
//                   .align(Alignment.BottomEnd),
//               verticalArrangement = Arrangement.Bottom,
//               ) {
//               Text(text = topHeadlinesItem?.title.toString(),
//                   color = Color.White,
//                   fontSize = 18.sp,
//                   fontWeight = FontWeight.Bold,
//                   fontFamily = nunitoFontFamilyBold
//               )
//               Spacer(modifier = Modifier.size(5.dp))
//               Text(
//                   modifier = Modifier.fillMaxWidth(),
//                   text = topHeadlinesItem?.publishedAt?.formatDate().toString(),
//                   color = Color.White,
//                   fontWeight = FontWeight.Bold,
//                   fontFamily = nunitoFontFamilyBold,
//                   fontSize = 12.sp,
//                   textAlign = TextAlign.End
//               )
//           }
//       }
//
//   }
//
//
//    }
//
//
//}
//@Composable
//fun TopHeadlines(){
//
//}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(
              //currentScreen: TopHeadlinesScreens,
              canNavigateBack: Boolean,
              navigateUp: () -> Unit,
              modifier: Modifier = Modifier
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text =  "BBC NEWS",//currentScreen.name,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
        },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
            containerColor = Color.Black,
            titleContentColor = Color.White
        ),
        modifier = modifier,
        navigationIcon = {
//            val backStackEntry = navController.previousBackStackEntry
//            println("Zibah:: BACK $backStackEntry")
           // if (canNavigateBack) {
                IconButton(
                    onClick =
                    navigateUp
                ) {
                    Icon(
                        imageVector = Icons.Filled.ArrowBack,
                        contentDescription = "back",
                        tint = Color.White
                    )
                //}
            }
        }

    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TopHeadlinesAppComposeTheme {
//       TopHeadLinesItemComposable(topHeadlinesItem = TopHeadlinesItem(
//           "Birmingham sack Rooney after 15 games in charge",
//           "Birmingham sack Rooney after 15 games in charge",
//           "",
//           "",
//           "2024-01-02T12:22:23.4088451Z",
//           "") )
    }


}