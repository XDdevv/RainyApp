package zed.rainxch.rainyyy.core.presentation.navigation

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun AppBottomNav(
    navController: NavHostController,
    modifier: Modifier = Modifier,
) {
    NavigationBar(
        modifier = modifier.fillMaxWidth(),
        containerColor = MaterialTheme.colorScheme.primaryContainer
    ) {
        val dividerColor = MaterialTheme.colorScheme.onBackground
        val currentRoute by navController.currentBackStackEntryAsState()
        val selectedItemIndex by remember {
            derivedStateOf {
                when {
                    currentRoute?.destination?.route?.endsWith(
                        NavGraph.HomeScreen.route,
                        true
                    ) == true -> 0

                    currentRoute?.destination?.route?.endsWith(
                        NavGraph.ShortVideoScreen.route,
                        true
                    ) == true -> 1

                    currentRoute?.destination?.route?.endsWith(
                        NavGraph.VideosScreen.route,
                        true
                    ) == true -> 2

                    currentRoute?.destination?.route?.endsWith(
                        NavGraph.CommentsScreen.route,
                        true
                    ) == true -> 3

                    currentRoute?.destination?.route?.endsWith(
                        NavGraph.InfoScreen.route,
                        true
                    ) == true -> 4

                    else -> 0
                }
            }
        }

        BottomNavItem.getBottomNavItems().forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = {
                    navController.navigate(item.screen) {
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        imageVector = if (selectedItemIndex == index) {
                            item.selectedIcon
                        } else item.unselectedIcon,
                        contentDescription = item.title,
                        modifier = Modifier.size(24.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = Color.Transparent
                ),
                modifier = Modifier.drawBehind {
                    drawRect(
                        color = dividerColor,
                        topLeft = Offset(0f, 0f),
                        size = Size(width = size.width + 24f, height = 2f)
                    )
                }
            )
        }
    }
}