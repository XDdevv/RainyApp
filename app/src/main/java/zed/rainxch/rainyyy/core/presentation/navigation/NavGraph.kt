package zed.rainxch.rainyyy.core.presentation.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class NavGraph(val route: String) {
    @Serializable
    data object HomeScreen : NavGraph("HomeScreen")

    @Serializable
    data object ShortVideoScreen : NavGraph("ShortVideoScreen")

    @Serializable
    data object VideosScreen : NavGraph("VideosScreen")

    @Serializable
    data object CommentsScreen : NavGraph("CommentsScreen")

    @Serializable
    data object InfoScreen : NavGraph("InfoScreen")

}