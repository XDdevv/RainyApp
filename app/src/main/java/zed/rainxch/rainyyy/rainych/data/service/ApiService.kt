package zed.rainxch.rainyyy.rainych.data.service

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.setBody
import zed.rainxch.rainyyy.core.domain.Constants
//import zed.rainxch.rainyyy.rainych.domain.model.YouTubeSearchResponse
//import zed.rainxch.rainyyy.rainych.domain.model.YoutubeVideo

class ApiService (
    private val client: HttpClient
) {
//    suspend fun getPopularVideo() : YoutubeVideo {
//        return client.get("search") {
//            val searchResponse: YouTubeSearchResponse = client.get("search") {
//                parameter("part", "snippet")
//                parameter("channelId", Constants.CHANNEL_ID)
//                parameter("type", "video")
//                parameter("maxResults", 50)
//                parameter("key", Constants.API_KEY)
//            }.body()
//
//            val videoIds = searchResponse.items.mapNotNull { it.id.videoId }
//
//            // Step 2: Get statistics for videos
//            val statsResponse: YoutubeVideo = client.get("videos") {
//                parameter("part", "snippet,statistics")
//                parameter("id", videoIds.joinToString(","))
//                parameter("key", Constants.API_KEY)
//            }.body()
//
//            TODO()
////            return statsResponse.items.maxByOrNull { it.statistics.viewCount.toLongOrNull() ?: 0 }
//        }.body()
//    }
}