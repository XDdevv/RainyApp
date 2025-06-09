package zed.rainxch.rainyyy.core.presentation.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import zed.rainxch.rainyyy.R
import zed.rainxch.rainyyy.core.presentation.designsystem.theme.comment
import zed.rainxch.rainyyy.core.presentation.designsystem.theme.home
import zed.rainxch.rainyyy.core.presentation.designsystem.theme.info
import zed.rainxch.rainyyy.core.presentation.designsystem.theme.shortVideo
import zed.rainxch.rainyyy.core.presentation.designsystem.theme.video

data class BottomNavItem(
    val title: String,
    val unselectedIcon: ImageVector,
    val selectedIcon: ImageVector,
    val screen: NavGraph
) {
    companion object {
        @Composable
        fun getBottomNavItems(): List<BottomNavItem> {
            return listOf(
                BottomNavItem(
                    title = stringResource(R.string.home),
                    unselectedIcon = Icons.Outlined.home,
                    selectedIcon = Icons.Filled.home,
                    screen = NavGraph.HomeScreen
                ),
                BottomNavItem(
                    title = stringResource(R.string.shorts),
                    unselectedIcon = Icons.Outlined.shortVideo,
                    selectedIcon = Icons.Filled.shortVideo,
                    screen = NavGraph.ShortVideoScreen
                ),
                BottomNavItem(
                    title = stringResource(R.string.videos),
                    unselectedIcon = Icons.Outlined.video,
                    selectedIcon = Icons.Filled.video,
                    screen = NavGraph.VideosScreen
                ),
                BottomNavItem(
                    title = stringResource(R.string.comments),
                    unselectedIcon = Icons.Outlined.comment,
                    selectedIcon = Icons.Filled.comment,
                    screen = NavGraph.CommentsScreen
                ),
                BottomNavItem(
                    title = stringResource(R.string.about_her),
                    unselectedIcon = Icons.Outlined.info,
                    selectedIcon = Icons.Filled.info,
                    screen = NavGraph.InfoScreen
                )
            )
        }
    }
}