package components

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import colors
import dataDomain.*
import gateway.EventTrackingGateway

internal val LIST_PADDING = 16.dp

@Composable
internal fun ListView(
    sdList: SdList,
    eventTracking: EventTrackingGateway? = null,
) {
    when (sdList.orientation) {
        SdOrientation.Vertical -> {
            Column(
                modifier = getModifier(sdList),
                verticalArrangement = Arrangement.spacedBy(
                    space = LIST_PADDING,
                    alignment = Alignment.Top
                )
            ) {
                sdList.children.forEach { it.Composable(eventTracking) }
            }
        }
        SdOrientation.Horizontal -> {
            val scrollState = rememberScrollState()
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                verticalArrangement = Arrangement.Top
            ) {
                Row(
                    modifier = getModifier(sdList, scrollState),
                    horizontalArrangement = Arrangement.spacedBy(
                        space = LIST_PADDING,
                        alignment = Alignment.Start
                    )
                ) {
                    sdList.children.forEach { it.Composable(eventTracking) }
                }
                if (sdList.indicator?.showIndicator?.value == true) {
                    val size = sdList.children.size
                    if (scrollState.maxValue != 0 && scrollState.maxValue != Int.MAX_VALUE) {
                        FmWormPageIndicator(
                            totalPages = size,
                            currentPage = scrollState.value,
                            activeColor = sdList.indicator?.style?.indicatorColor?.toAndroidColor()
                                ?: colors.greens.green400Brand,
                            backgroundColor = sdList.indicator?.style?.backgroundColor?.toAndroidColor()
                                ?: colors.neutrals.white400,
                            modifier = Modifier.padding(top = 16.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun getModifier(sdList: SdList, state: ScrollState? = null): Modifier {
    return when (sdList.orientation) {
        SdOrientation.Vertical -> {
            if (sdList.scrollable is SdScrollable.Scroll) {
                Modifier
                    .fillMaxHeight()
                    .verticalScroll(state ?: rememberScrollState())
            } else {
                Modifier.wrapContentHeight()
            }
        }
        SdOrientation.Horizontal -> {
            if (sdList.scrollable is SdScrollable.Scroll) {
                Modifier
                    .fillMaxWidth()
                    .horizontalScroll(state ?: rememberScrollState())
                    .height(intrinsicSize = IntrinsicSize.Max)
            } else {
                Modifier
                    .fillMaxWidth()
                    .height(intrinsicSize = IntrinsicSize.Max)
            }
        }
    }
}
