package zed.rainxch.rainyyy.core.presentation.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import zed.rainxch.rainyyy.rainych.presentation.comment.CommentsScreen
import zed.rainxch.rainyyy.rainych.presentation.home.HomeScreen
import zed.rainxch.rainyyy.rainych.presentation.info.InfoScreen
import zed.rainxch.rainyyy.rainych.presentation.shortVideo.ShortVideoScreen
import zed.rainxch.rainyyy.rainych.presentation.video.VideosScreen

@Composable
fun AppNavigation(
    navController: NavHostController
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        bottomBar = {
            AppBottomNav(navController = navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = NavGraph.HomeScreen,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable<NavGraph.HomeScreen> {
                HomeScreen(
                    onNavigateToSearch = {

                    }
                )
            }
            composable<NavGraph.ShortVideoScreen> {
                ShortVideoScreen()
            }
            composable<NavGraph.VideosScreen> {
                VideosScreen()
            }
            composable<NavGraph.CommentsScreen> {
                CommentsScreen()
            }
            composable<NavGraph.InfoScreen> {
                InfoScreen()
            }
        }
    }
}