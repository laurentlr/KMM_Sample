package components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import dataDomain.SdTopCard
import dimens
import gateway.EventTrackingGateway
import typography

// TODO FC-13110
private const val TOP_CARD_VIEW = "TOP_CARD_VIEW"

@Composable
internal fun TopCardView(
    topCard: SdTopCard,
    eventTracking: EventTrackingGateway? = null,
) {
    val rememberCoroutineScope = rememberCoroutineScope()
    var isObfuscated = false
    Card(
        shape = RoundedCornerShape(dimens.standard100),
        colors = CardDefaults.cardColors(
            containerColor = topCard.style?.backgroundColor.toAndroidColor()
                .default(MaterialTheme.colorScheme.surface)
        ),
        border = BorderStroke(1.dp, topCard.style?.borderColor.toAndroidColor()),
        modifier = Modifier.fillMaxWidth(),
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimens.standard100),
        )
        {
            Column {
                Title(
                    topCard,
                    isObfuscated,
                )
                Body(topCard, isObfuscated)
                Button(topCard, eventTracking)
            }
            Icon(
                topCard,
                Modifier
                    .height(dimens.standard150)
                    .width(dimens.standard150)

                    .clickable(topCard.isObfuscable()) {
                    },
                isObfuscated,
            )
        }

    }
}

@Composable
private fun Title(topCard: SdTopCard, isObfuscated: Boolean) {
    topCard.getTitle(isObfuscated)?.let {
        SdTextView(
            sdText = it,
            modifier = Modifier,
            style = typography.titleLarge,
        )
    }
}

@Composable
private fun Body(topCard: SdTopCard, isObfuscated: Boolean) {
    topCard.getSubtitle(isObfuscated)?.let {
        SdTextView(
            sdText = it,
            modifier = Modifier,
            style = typography.titleTiny.copy(fontWeight = FontWeight.Normal),
        )
    }
}

@Composable
private fun Button(topCard: SdTopCard, eventTracking: EventTrackingGateway? = null) {
    topCard.button?.let {
        Box(
            modifier = Modifier
                .padding(top = dimens.standard50)
        ) {
            ButtonView(it)
        }
    }
}

@Composable
private fun Icon(topCard: SdTopCard, modifier: Modifier, isObfuscated: Boolean) {
    topCard.getIcon(isObfuscated)?.let {
         FmSvgImage(
             url = it.uri,
             modifier = modifier
         )
    }
}

