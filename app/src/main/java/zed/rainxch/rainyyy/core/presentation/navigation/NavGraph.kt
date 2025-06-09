package zed.rainxch.rainyyy.core.presentation.navigation

import kotlinx.serialization.Serializable

sealed class NavGraph {
    @Serializable
    data object HomeScreen : NavGraph()

    @Serializable
    data object ShortVideoScreen : NavGraph()

    @Serializable
    data object VideosScreen : NavGraph()

    @Serializable
    data object CommentsScreen : NavGraph()

    @Serializable
    data object InfoScreen : NavGraph()

}