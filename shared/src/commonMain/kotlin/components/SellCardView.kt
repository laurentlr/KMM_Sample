package components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import colors
import dataDomain.SdSellCard
import dimens
import gateway.EventTrackingGateway
import gateway.TrackingEvent

private const val IconTag = "icon"
private const val TitleTag = "title"
private const val BodyTag = "body"
private val ViewWidth = 128.dp

@Composable
internal fun SellCardView(
    sdSellCard: SdSellCard,
    eventTracking: EventTrackingGateway? = null,
) {
    Box(
        modifier = Modifier
            .background(
                color = sdSellCard.style?.backgroundColor.toAndroidColor(),
                shape = RoundedCornerShape(dimens.standard100),
            )
            .clickable {
                clickButton(sdSellCard, eventTracking)
            }
            .width(ViewWidth)
            .fillMaxHeight(),
    ) {
        Background(
            sdSellCard,
            Modifier.fillMaxSize(),
        )
        Column(
            modifier = Modifier
                .padding(dimens.standard100)
                .fillMaxSize(),
            verticalArrangement = Arrangement
                .spacedBy(
                    space = dimens.standard25,
                    alignment = Alignment.Top,
                )
        ) {
            Icon(sdSellCard)
            Title(sdSellCard)
            Body(sdSellCard)
            Spacer(modifier = Modifier.weight(1f))
            Button(sdSellCard, eventTracking)
        }
    }
}

@Composable
fun Background(sdSellCard: SdSellCard, modifier: Modifier) {
    sdSellCard.style?.backgroundImage?.let {
         FmSvgImage(
             url = it.uri,
             modifier = modifier
                 .clip(RoundedCornerShape(dimens.standard100)),
             contentScale = ContentScale.Crop,
         )
    }
}

@Composable
fun Icon(sdSellCard: SdSellCard) {
    sdSellCard.icon?.let {
        FmSvgImage(
            url = it.uri,
            modifier = Modifier
                .height(dimens.standard200)
                .width(dimens.standard200)
                .testTag(IconTag)
        )
    }
}

@Composable
fun Title(sdSellCard: SdSellCard) {
    sdSellCard.title?.let {
        SdTextView(
            sdText = it,
            modifier = Modifier.testTag(TitleTag),
            style = typography.titleSmall.copy(
                color = sdSellCard.title?.sdStyle?.textColor.toAndroidColor()
                    .default(colors.neutrals.white100Primary)
            ),
        )
    }
}

@Composable
fun Body(sdSellCard: SdSellCard) {
    sdSellCard.body?.let {
        SdTextView(
            sdText = it,
            modifier = Modifier.testTag(BodyTag),
            style = typography.bodySmall.copy(
                color = sdSellCard.body?.sdStyle?.textColor.toAndroidColor()
                    .default(colors.neutrals.white300Tertiary)
            ),
        )
    }
}

@Composable
fun Button(sdSellCard: SdSellCard, eventTracking: EventTrackingGateway? = null) {
    sdSellCard.button?.let { ButtonView(it) }
}


private fun clickButton(
    sellCard: SdSellCard,
    eventTracking: EventTrackingGateway? = null,
) {
    sellCard.clickable?.let {
        it.tracking?.let { tracking ->
            eventTracking?.trackInteraction(TrackingEvent(tracking.name, tracking.params))
        }
        //context.openDeepLink(it.deeplink)
    }
}
