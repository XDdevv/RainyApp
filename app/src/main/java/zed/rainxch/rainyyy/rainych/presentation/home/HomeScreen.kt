package zed.rainxch.rainyyy.rainych.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import zed.rainxch.rainyyy.R
import zed.rainxch.rainyyy.core.presentation.designsystem.theme.RainyyyTheme
import zed.rainxch.rainyyy.rainych.presentation.home.components.HomeTab

@Composable
fun HomeScreenRoot(
    modifier: Modifier = Modifier,
    onNavigateToSearch: () -> Unit,
) {
    HomeScreen(
        modifier = modifier,
        onNavigateToSearch = onNavigateToSearch
    )
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onNavigateToSearch: () -> Unit,
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Spacer(Modifier.width(52.dp))
            Text(
                text = stringResource(R.string.rainych_ran),
                style = MaterialTheme.typography.headlineLarge
            )
            IconButton(
                onClick = onNavigateToSearch
            ) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search"
                )
            }
        }

        Spacer(Modifier.height(16.dp))

        val pagerState = rememberPagerState { 2 }
        HomeTab(pagerState = pagerState)
    }
}

@Preview(showBackground = true)
@Composable
private fun HomeScreenPreview() {
    RainyyyTheme {
        HomeScreen(onNavigateToSearch = {})
    }
}