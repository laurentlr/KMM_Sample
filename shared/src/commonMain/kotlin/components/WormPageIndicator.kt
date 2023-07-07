package components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun FmWormPageIndicator(
    totalPages: Int,
    currentPage: Int,
    modifier: Modifier = Modifier,
    indicatorSize: Dp = 6.dp,
    activeColor: Color = Color.Blue,
    backgroundColor: Color = Color.Gray,
    spacing: Dp = indicatorSize,
    selectedMultiplier: Int = 3,
) {
    val rowWidth: Dp by remember(indicatorSize, selectedMultiplier, totalPages, spacing) {
        mutableStateOf(
            indicatorSize * (selectedMultiplier + (totalPages - 1)) + (spacing * (totalPages - 1))
        )
    }

    Row(
        modifier = modifier
            .requiredWidth(rowWidth),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        for (i in 0 until totalPages) {
            val selected = i == currentPage

            val width: Dp by animateDpAsState(
                if (selected) indicatorSize * selectedMultiplier else indicatorSize
            )

            Canvas(
                modifier = Modifier
                    .size(width, indicatorSize),
                onDraw = {
                    drawRoundRect(
                        color = if (selected) activeColor else backgroundColor,
                        cornerRadius = CornerRadius(indicatorSize.toPx() / 2),
                        size = Size(width.toPx(), indicatorSize.toPx())
                    )
                }
            )
        }
    }
}
