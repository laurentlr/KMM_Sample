package components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dataDomain.*
import dimens

private const val TitleTag = "title"
private const val SubtitleTag = "subtitle"
private const val ButtonTag = "button"
private const val IconTag = "icon"

val visibleMargin = 16.dp
val goneMargin = 0.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun BannerView(
    banner: SdBanner,
) {
    Card(
        modifier = Modifier.defaultMinSize(minWidth = 240.dp),
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = banner.style?.backgroundColor.toAndroidColor()
        ),
        border = BorderStroke(1.dp, banner.style?.borderColor.toAndroidColor()),
    ) {
        BannerViewContent(
            icon = banner.icon,
            title = banner.title,
            body = banner.body,
            button = banner.buttons.firstOrNull(),
        )
    }
}

fun SdColor?.toAndroidColor(): Color {
    return this?.value?.let(::Color) ?: Color.Unspecified
}

@Composable
private fun BannerViewContent(
    icon: SdIcon?,
    title: SdText?,
    body: SdText?,
    button: SdButton?,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        icon?.let { Icon(it) }
        Column(modifier = Modifier) {
            title?.let { Title(it, Modifier) }
            if (title != null && body != null) {
                Spacer(modifier = Modifier.height(4.dp))
            }
            body?.let { Body(it) }
        }
        button?.let { Button(it) }
    }
}


@Composable
private fun Icon(iconUrl: SdIcon?, modifier: Modifier = Modifier) {
    Box(modifier = modifier) {
        iconUrl?.let {
            FmSvgImage(
                url = it.uri,
                modifier = Modifier
                    .width(dimens.standard150)
                    .height(dimens.standard150)
                    .testTag(IconTag),
            )
        }
    }
}

@Composable
fun Title(sdText: SdText?, modifier: Modifier) {
    sdText?.let {
        SdTextView(
            sdText = it,
            style = getTinyTextStyle(),
            modifier = modifier
                .testTag(TitleTag)
        )
    }
}

@Composable
private fun Body(sdText: SdText?, modifier: Modifier = Modifier) {
    sdText?.let {
        SdTextView(
            sdText = it,
            style = getBodyTinyStyle(),
            modifier = modifier
                .testTag(SubtitleTag)
        )
    }
}

@Composable
private fun Button(
    sdButton: SdButton?,
    modifier: Modifier = Modifier,
) {
    sdButton?.let {
        ButtonView(it)
    }
}

private fun getTinyTextStyle() = TextStyle.Default.copy(
    fontSize = 12.sp,
    lineHeight = 16.sp,
    fontWeight = FontWeight.SemiBold,
    color = Color(0xff61647B),
)

private fun getBodyTinyStyle() = TextStyle.Default.copy(
    fontSize = 12.sp,
    lineHeight = 16.sp,
    fontWeight = FontWeight.Normal,
    color = Color(0xff61647B),
)

