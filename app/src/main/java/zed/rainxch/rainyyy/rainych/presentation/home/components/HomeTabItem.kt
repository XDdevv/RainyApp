package zed.rainxch.rainyyy.rainych.presentation.home.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun HomeTabItem(
    title: String,
    isSelected: Boolean,
    onTabSelected: () -> Unit,
    modifier: Modifier = Modifier
) {
    val contentColor = if (isSelected) {
        MaterialTheme.colorScheme.primary
    } else MaterialTheme.colorScheme.secondary
    TextButton(
        modifier = modifier
            .padding(end = 16.dp)
            .drawBehind {
                drawRect(
                    color = contentColor,
                    topLeft = Offset(x = 0f, y = size.height),
                    size = Size(width = size.width, height = 2.dp.toPx())
                )
            },
        onClick = onTabSelected,
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
            contentColor = contentColor
        )
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.bodyLarge
        )
    }
}