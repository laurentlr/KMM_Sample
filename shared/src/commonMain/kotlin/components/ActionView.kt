package components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import colors
import dataDomain.SdAction
import dataDomain.SdIcon
import dataDomain.SdText
import dimens
import gateway.EventTrackingGateway
import gateway.TrackingEvent
import typography

private const val IconTag = "icon"
private const val TextTag = "text"
private const val INNER_PADDING = 2

@Composable
internal fun ActionView(
    action: SdAction,
    shimmerVisibility: Boolean = false,
    eventTracking: EventTrackingGateway? = null,
) {
    Column(
        verticalArrangement = Arrangement
            .spacedBy(
                space = dimens.standard50,
                alignment = Alignment.Top,
            ),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .run {
                action.deeplink?.let {
                    this.clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = rememberRipple(bounded = false),
                        onClick = {
                            action.tracking?.let {
                                eventTracking?.trackInteraction(TrackingEvent(it.name, it.params))
                            }
                            //context.openDeepLink(it)
                        }
                    )
                } ?: this
            }
            .padding(horizontal = INNER_PADDING.dp)
            .fillMaxSize()
    ) {
        Icon(action.icon, shimmerVisibility)
        Text(action.actionText, shimmerVisibility)
    }
}

@Composable
private fun Icon(icon: SdIcon?, shimmerVisibility: Boolean) {
    icon?.let {
        FmSvgImage(
            url = it.uri,
            modifier = Modifier
                .height(dimens.standard250)
                .width(dimens.standard250)
                .testTag(IconTag)
        )
    }
}

@Composable
private fun Text(actionText: SdText?, shimmerVisibility: Boolean) {
    actionText?.let {
        SdTextView(
            sdText = it,
            modifier = Modifier
                .fillMaxWidth()
                /* .placeholder(
                     visible = shimmerVisibility,
                     highlight = PlaceholderHighlight.shimmer(),
                 )*/
                .testTag(TextTag),
            style = typography.titleTiny.copy(
                color = it.sdStyle?.textColor.toAndroidColor()
                    .default(colors.neutrals.black200TextPrimary)
            ),
            textAlign = TextAlign.Center,
        )
    }
}
