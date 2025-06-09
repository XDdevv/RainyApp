package zed.rainxch.rainyyy.rainych.presentation.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import kotlinx.coroutines.launch

@Composable
fun HomeTab(
    pagerState: PagerState,
    modifier: Modifier = Modifier
) {
    val scope = rememberCoroutineScope()
    val tabs = listOf("All videos", "Shorts")
    val selectedTabIndex = pagerState.currentPage
    Column(modifier = modifier.fillMaxSize()) {
        Row {
            tabs.forEachIndexed { index, tab ->
                HomeTabItem(
                    title = tab,
                    isSelected = index == selectedTabIndex,
                    onTabSelected = {
                        scope.launch {
                            pagerState.scrollToPage(index)
                        }
                    }
                )
            }
        }

        HorizontalPager(
            state = pagerState,
            modifier = Modifier
        ) {
            if (selectedTabIndex == 0) {
                HomeMainContent()
            } else {
                Text(text = "Shorts")
            }
        }
    }
}