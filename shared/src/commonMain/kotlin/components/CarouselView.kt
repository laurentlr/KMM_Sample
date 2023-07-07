@file:OptIn(ExperimentalFoundationApi::class)

package components

import FmDimens
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import colors
import dataDomain.SdAction
import dataDomain.SdCarousel
import dataDomain.SdTopCardWithActions
import dimens
import gateway.EventTrackingGateway
import kotlinx.coroutines.delay
import kotlinx.datetime.Clock
import kotlin.math.abs
import kotlin.math.sign

private const val ACTION_ROW_RATIO = 4F
private const val ACTION_RATIO = 1F
private const val EIGHTY_PERCENT = 0.8F
private const val PLACEHOLDER_DISPLAY_DELAY = 100L

@OptIn(ExperimentalFoundationApi::class)
@Composable
internal fun CarouselView(sdCarousel: SdCarousel, eventTracking: EventTrackingGateway? = null) {
    val state = rememberPagerState()
    Column {
        HorizontalPager(
            pageCount = sdCarousel.children.size,
            state = state,
            contentPadding = PaddingValues(
                horizontal = dimens.standard200
            ),
            pageSpacing = dimens.standard100,
            verticalAlignment = Alignment.Top,
        ) { page ->
            sdCarousel.children[page].Composable(eventTracking)
        }
        FmWormPageIndicator(
            totalPages = sdCarousel.children.size,
            currentPage = state.currentPage,
            activeColor = colors.greens.green400Brand,
            backgroundColor = colors.neutrals.white400,
            modifier = Modifier.padding(top = 16.dp)
        )
        QuickActions(dimens, state, sdCarousel, eventTracking)
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun QuickActions(
    dimens: FmDimens,
    state: PagerState,
    sdCarousel: SdCarousel,
    eventTracking: EventTrackingGateway? = null,
) {
    var shouldDisplayPlaceHolder by remember { mutableStateOf(false) }
    var lastShouldDisplayPlaceHolder = false
    var lastOffset = 0F
    Row(
        horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = dimens.standard100)
            .horizontalScroll(
                enabled = false,
                state = rememberScrollState(),
            )
            .aspectRatio(ACTION_ROW_RATIO)
            .height(intrinsicSize = IntrinsicSize.Max)
            .alpha(if (state.is80percentDisplayed()) state.getAlpha() else 1F),
    ) {
        LaunchedEffect(Clock.System.now()) {
            shouldDisplayPlaceHolder =
                if (state.currentPageOffsetFraction.hasNoDecimal() && lastOffset.hasNoDecimal()) {
                    lastOffset = state.currentPageOffsetFraction
                    delay(PLACEHOLDER_DISPLAY_DELAY)
                    false
                } else {
                    lastOffset = state.currentPageOffsetFraction
                    !state.is80percentDisplayed()
                }
        }

        if (state.is80percentDisplayed()) {
            getSdActions(sdCarousel, state)?.forEach {
                Box(
                    modifier = Modifier
                        .aspectRatio(ACTION_RATIO)
                        .fillMaxHeight()
                ) {
                    it.Composable(shouldDisplayPlaceHolder, eventTracking)
                }
            }
        } else {
            getNextSdActions(sdCarousel, state)
                ?.forEach {
                    Box(
                        modifier = Modifier
                            .aspectRatio(ACTION_RATIO)
                            .fillMaxHeight()
                    ) {
                        it.Composable(
                            shouldDisplayPlaceHolder || !lastShouldDisplayPlaceHolder,
                            eventTracking
                        )
                    }
                }
        }
        lastShouldDisplayPlaceHolder = shouldDisplayPlaceHolder
    }
}

@Composable
private fun getNextSdActions(
    sdCarousel: SdCarousel,
    state: PagerState,
) =
    (sdCarousel.children[state.currentPage + state.currentPageOffsetFraction.sign.toInt()] as? SdTopCardWithActions)
        ?.actions
        ?.children
        ?.filterIsInstance<SdAction>()

@OptIn(ExperimentalFoundationApi::class)
@Composable
private fun getSdActions(
    sdCarousel: SdCarousel,
    state: PagerState,
) = (sdCarousel.children[state.currentPage] as? SdTopCardWithActions)
    ?.actions
    ?.children
    ?.filterIsInstance<SdAction>()

private fun PagerState.is80percentDisplayed(): Boolean {
    return abs(this.currentPageOffsetFraction) < EIGHTY_PERCENT
}

private fun PagerState.getAlpha(): Float = 1 - abs(this.currentPageOffsetFraction)

private fun Float.hasNoDecimal() = this % 1F == 0F
